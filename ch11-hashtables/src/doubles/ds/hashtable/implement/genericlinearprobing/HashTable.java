package doubles.ds.hashtable.implement.genericlinearprobing;

// 해시테이블 클래스
@SuppressWarnings("unckecked")
public class HashTable<Key, Value> {

    private Key[] keys;     // 키 테이블
    private Value[] values; // 값 테이블
    private int numOfItems; // 해시테이블에 저장된 항목의 수
    private int capacity;   // 해시테이블의 사이즈

    // 기본 생성자
    public HashTable() {
        this.keys = (Key[]) new Object[Constants.TABLE_SIZE];
        this.values = (Value[]) new Object[Constants.TABLE_SIZE];
        this.numOfItems = 0;
        this.capacity = Constants.TABLE_SIZE;
    }

    // 사이즈 변환을 위한 생성자
    private HashTable(int newCapacity) {
        this.keys = (Key[]) new Object[newCapacity];
        this.values = (Value[]) new Object[newCapacity];
        this.numOfItems = 0;
        this.capacity = newCapacity;
    }

    // 사이즈 반환
    public int size() {
        return this.numOfItems;
    }

    // 해시테이블이 비었는지 확인
    public boolean isEmpty() {
        return this.numOfItems == 0;
    }

    // 해시 함수
    public int hash(Key key) {
        //return key.hashCode() % this.capacity;
        // 음수값을 반환하지 않도록 abs() 메서드 사용
        return Math.abs(key.hashCode()) % this.capacity;
    }

    // 삽입
    public void put(Key key, Value value) {

        // 삽입 값이 없으면 메서드 종료
        if (key == null || value == null) {
            return;
        }

        // 해시테이블 슬롯이 거의다 차있으면 슬롯 수를 2배 증가 : 동적 해싱
        if (numOfItems >= capacity * 0.75) {
            resize(2 * capacity);
        }

        // 키 해싱
        int index = hash(key);

        // 해시테이블 슬롯의 빈공간을 찾을 때까지 반복 수행
        while (keys[index] != null) {

            // 이미 키값과 동일한 데이터가 존재하면 업데이트 수행
            if (keys[index].equals(key)) {
                values[index] = value;
                return;
            }

            // 반복 수행을 위해 인덱스 1 증가
            index = (index + 1) % capacity;
        }

        // 슬롯의 빈공간에 삽입처리
        keys[index] = key;
        values[index] = value;
        numOfItems++;
    }

    // 탐색
    public Value get(Key key) {

        // 키 값이 null 이면 메서드 종료
        if (key == null) {
            return null;
        }

        int index = hash(key); // 키 값 해싱

        // 해시 키값에 대응하는 해시 키값을 찾을 때까지 탐색
        while (keys[index] != null) {

            // 입력한 키값에 대응하는 키값이 해시테이블에 존재하면 값을 반환
            if (keys[index].equals(key)) {
                return values[index];
            }

            // 반복 수행을 위해 인덱스 1 증가
            index = (index + 1) % capacity;
        }

        return null;
    }

    // 삭제
    public void remove(Key key) {

        // 키 값이 null 이면 메서드 종료
        if (key == null) {
            return;
        }

        int index = hash(key); // 키 값을 해싱

        // 해시테이블에 입력한 키 값에 대응하는 키 값이 존재하지 않을 때까지 탐색
        while (!keys[index].equals(key)) {

            // 반복 수행 인덱스 1씩 증가
            index = (index + 1) % capacity;
        }

        // 해당 키와 값 제거
        keys[index] = null;
        values[index] = null;

        // 삭제 뒤 해시테이블을 재구성을 하지 않으면 공백이 생기고
        // get() 메서드가 제대로 작동하지 않게 된다.

        // 해시테이블 재구성을 위해 인덱스 1 증가
        index = (index + 1) % capacity;

        // 삭제한 슬롯 다음의 슬롯을 한칸 씩 앞으로 이동
        while (keys[index] != null) {

            Key tempKey = keys[index];          // 이동할 키 할당
            Value tempValue = values[index];    // 이동할 값 할당

            keys[index] = null;     // 키 제거
            values[index] = null;   // 값 제거

            numOfItems--;            // put()메서드에서 다시 증가시키기 때문에 배열 사이즈 1 감소
            put(tempKey, tempValue); // 앞의 슬롯에 삽입

            // 인덱스 1 증가
            index = (index + 1) % capacity;

        }

        numOfItems--; // 삭제 처리 후 배열 사이즈 1 감소

        // 배열의 항목 수가 테이블의 크기보다 1/3보다 작으면 1/2로 사이즈 감소
        if (numOfItems <= capacity / 3) {
            resize(capacity / 2);
        }

    }

    // 사이즈 변환
    public void resize(int newCapacity) {

        System.out.println("Resize table with new capacity : " + newCapacity);

        HashTable<Key, Value> newTable = new HashTable<>(newCapacity); // 새로운 해시테이블 생성

        // 기존의 해시테이블의 키와 값을 크가기 변경된 해시테이블에 저장
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                newTable.put(keys[i], values[i]);
            }
        }

        keys = newTable.getKeys();          // 새로운 해시테이블의 키 할당
        values = newTable.getValues();      // 새로운 해시테이블의 값 할당
        capacity = newTable.getCapacity();  // 새로운 해시테이블의 사이즈 할당
    }

    private Key[] getKeys() {
        return keys;
    }

    private Value[] getValues() {
        return values;
    }

    private int getCapacity() {
        return capacity;
    }

}
