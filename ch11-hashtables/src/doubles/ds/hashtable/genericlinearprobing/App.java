package doubles.ds.hashtable.genericlinearprobing;

public class App {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("a", 1);
        System.out.println(hashTable.size());
        hashTable.put("b", 2);
        System.out.println(hashTable.size());
        hashTable.put("c", 3);
        System.out.println(hashTable.size());
        hashTable.put("d", 4);
        System.out.println(hashTable.size());
        hashTable.put("e", 5);
        System.out.println(hashTable.size());
        hashTable.put("f", 6);
        System.out.println(hashTable.size());
        hashTable.put("g", 7);
        System.out.println(hashTable.size());
        hashTable.put("h", 8);
        System.out.println(hashTable.size());
        hashTable.put("j", 9);
        System.out.println(hashTable.size());
        hashTable.put("k", 10);
        System.out.println(hashTable.size());
        hashTable.put("l", 11);
        System.out.println(hashTable.size());
        hashTable.put("m", 12);
        System.out.println(hashTable.size());
        hashTable.put("n", 13);
        System.out.println(hashTable.size());
        hashTable.put("bb", 14);
        System.out.println(hashTable.size());
        hashTable.put("v", 15);
        System.out.println(hashTable.size());
        hashTable.put("bbc", 16);
        System.out.println(hashTable.size());
        hashTable.put("x", 17);
        System.out.println(hashTable.size());
        hashTable.put("y", 18);
        System.out.println(hashTable.size());

        hashTable.remove("c");
        System.out.println(hashTable.size());

        hashTable.remove("h");
        System.out.println(hashTable.size());
        hashTable.remove("j");
        System.out.println(hashTable.size());
        hashTable.remove("k");
        System.out.println(hashTable.size());
        hashTable.remove("l");
        System.out.println(hashTable.size());
        hashTable.remove("m");
        System.out.println(hashTable.size());
        hashTable.remove("n");
        System.out.println(hashTable.size());
        hashTable.remove("bb");
        System.out.println(hashTable.size());
        hashTable.remove("v");
        System.out.println(hashTable.size());
        hashTable.remove("bbc");
        System.out.println(hashTable.size());
        hashTable.remove("x");
        System.out.println(hashTable.size());
        hashTable.remove("a");
        System.out.println(hashTable.size());
        hashTable.remove("b");
        System.out.println(hashTable.size());
        hashTable.remove("d");
        System.out.println(hashTable.size());
        hashTable.remove("e");
        System.out.println(hashTable.size());
        hashTable.remove("f");
        System.out.println(hashTable.size());
    }
}
