package doubles.ds.trie;

public class App {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("approve");
        trie.insert("air");
        trie.insert("appa");
        trie.insert("appb");
        System.out.println(trie.search("apple"));
    }
}
