package doubles.ds.hashtable.chainig;

public class App {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put(1, 10);
        hashTable.put(2, 20);
        hashTable.put(3, 30);
        hashTable.put(4, 40);
        hashTable.put(5, 50);
        hashTable.put(6, 60);
        hashTable.put(7, 70);
        hashTable.put(8, 80);
        hashTable.put(9, 90);
        hashTable.put(10, 100);
        hashTable.put(11, 110);
        hashTable.put(12, 120);
        hashTable.put(22, 220);

        System.out.println(hashTable.get(11));
        System.out.println(hashTable.get(12));
        System.out.println(hashTable.get(2));
        System.out.println(hashTable.get(222));
    }


}
