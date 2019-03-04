package doubles.ds.trie;

public class App {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple", 1);
        trie.insert("approve", 2);
        trie.insert("air", 3);
        trie.insert("appa", 4);
        trie.insert("appb", 5);
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("archive"));
        System.out.println(trie.searchAsMap("apple"));
        System.out.println(trie.searchAsMap("archive"));
    }
}
