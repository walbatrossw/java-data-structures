package doubles.ds.hashtable.genericlinearprobing;

@SuppressWarnings("unckecked")
public class HashTable<Key, Value> {

    private Key[] keys;     // 해시테이블
    private Value[] values; // 키에 대응되는 데이터 저장
    private int numOfItems; // 항목의 수
    private int capacity;   // 테이블 사이즈

    public HashTable() {
        this.keys = (Key[]) new Object[Constants.TABLE_SIZE];
        this.values = (Value[]) new Object[Constants.TABLE_SIZE];
        this.numOfItems = 0;
        this.capacity = Constants.TABLE_SIZE;
    }

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
        // 문자열일 경우 해싱
        return key.hashCode() % this.capacity;
    }

    // 삽입
    public void put(Key key, Value value) {

        // 아무값도 없으면 메서드 종료
        if (key == null || value == null) {
            return;
        }

        // 배열의 슬롯이 거의다 차있으면 슬롯의 수를 2배 증가
        if (numOfItems >= capacity * 0.75) {
            resize(2 * capacity);
        }

        int index = hash(key);

        // 배열의 슬릇이 공백일 때까지 반복 수행
        while (keys[index] != null) {

            // 입력된 키와 저장된 키가 같을 경우 업데이트, 메서드 종료
            if (keys[index].equals(key)) {
                values[index] = value;
                return;
            }
            // 인덱스 1 증가
            index = (index + 1) % capacity;
        }

        // 삽입처리
        keys[index] = key;
        values[index] = value;
        numOfItems++;
    }

    // 반환
    public Value get(Key key) {

        // 키 값이 null이면
        if (key == null) {
            return null;
        }

        int index = hash(key); // 키 값을 해싱

        // 해시 키값에 대응하는 해시 키값이 null일 때까지 반복
        while (keys[index] != null) {

            // 입력한 키값에 대응하는 키값이 배열에 존재하면 값을 반환
            if (keys[index].equals(key)) {
                return values[index];
            }

            // 인덱스 1 증가
            index = (index + 1) % capacity;
        }

        return null;
    }

    // 삭제
    public void remove(Key key) {
        if (key == null) {
            return;
        }

        int index = hash(key); // 키 값을 해싱

        // 입력한 키 값에 대응하는 키 값이 배열에 존재하지 않을 때까지 반복 수행
        while (!keys[index].equals(key)) {
            // 인덱스 1씩 증가
            index = (index + 1) % capacity;
        }

        // 키와 값 제거
        keys[index] = null;
        values[index] = null;

        // 삭제 뒤 배열을 재구성을 하지 않으면 공백이 생기고 get() 메서드가 제대로 작동하지 않게 된다.
        // 배열 재구성을 위해 인덱스 1 증가
        index = (index + 1) % capacity;

        // 배열의 슬롯이 공백일 때까지 반복 수행
        while (keys[index] != null) {

            Key tempKey = keys[index];          // 이동할 키 할당
            Value tempValue = values[index];    // 이동할 값 할당

            keys[index] = null;     // 키 제거
            values[index] = null;   // 값 제거

            numOfItems--;            // put()메서드에서 다시 증가시키기 때문에 배열 사이즈 1 감소
            put(tempKey, tempValue); // 다시 삽입

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

        // 기존의 해시테이블의 키와 값을 새로운 해시테이블에 저장
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                newTable.put(keys[i], values[i]);
            }
        }

        keys = newTable.getKeys();          // 새로운 테이블의 키 할당
        values = newTable.getValues();      // 새로운 테이블의 값 할당
        capacity = newTable.getCapacity();  // 새로운 테이블의 사이즈 할당
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
