package doubles.ds.hashtable.implement.chainig;

public class HashTable {

    private HashItem[] hashTable;

    public HashTable() {
        this.hashTable = new HashItem[Constants.TABLE_SIZE];
    }

    // 해시 함수
    private int hash(int key) {
        // 키 % 테이블 사이즈 : 나머지 연산
        return key % Constants.TABLE_SIZE;
    }

    // 삽입
    public void put(int key, int value) {

        // 키를 해싱
        int hashArrayIndex = hash(key);

        // 해시 테이블의 슬롯이 비어 있으면 바로 삽입
        if (hashTable[hashArrayIndex] == null) {

            System.out.println("no collision simple insertion");
            hashTable[hashArrayIndex] = new HashItem(key, value);

        } else { // 해쉬 테이블의 슬롯이 비어있지 않으면

            System.out.println("collision when inserting with key : " + key);
            HashItem hashItem = hashTable[hashArrayIndex]; // 해시테이블 슬롯에 저장된 첫번째 항목 추출

            // 연결리스트 마지막까지 탐색를 수행
            while (hashItem.getNextHashItem() != null) {
                hashItem = hashItem.getNextHashItem();
                System.out.println("Considering the next item in linked list " + hashItem.getValue());
            }
            // 마지막으로 연결 리스트 다음에 삽입
            System.out.println("Finally we have found the place to insert...");
            hashItem.setNextHashItem(new HashItem(key, value));
        }
    }

    // 반환
    public int get(int key) {

        // 입력받은 키값을 해싱
        int generatedArrayIndex = hash(key);

        // 해시 값에 해당하는 슬롯에 데이터가 없으면 -1 리턴
        if (hashTable[generatedArrayIndex] == null) {

            return -1;

        } else { // 해시 값에 해당하는 슬롯에 데이터가 있는 경우

            // 첫번째 항목 추출
            HashItem hashItem = hashTable[generatedArrayIndex];

            // 입력 키 값과 항목의 키 값이 일치할 때까지 탐색
            while (hashItem != null && hashItem.getKey() != key) {
                hashItem = hashItem.getNextHashItem();
            }

            // 마지막까지 탐색한 뒤 일치하는 값을 못찾은 경우 -1 리턴
            if (hashItem == null) {
                return -1;
            } else { // 값 리턴
                return hashItem.getValue();
            }
        }

    }


}
