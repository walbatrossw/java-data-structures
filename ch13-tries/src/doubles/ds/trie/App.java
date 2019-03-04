package doubles.ds.trie;

import java.util.List;

public class App {
    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("apple", 1);
        trie.insert("approve", 2);
        trie.insert("air", 3);
        trie.insert("appa", 4);
        trie.insert("appb", 5);

        System.out.println("---- search : true or false ----");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("archive"));

        System.out.println();

        System.out.println("---- search : as map ----");
        System.out.println(trie.searchAsMap("apple"));
        System.out.println(trie.searchAsMap("archive"));

        System.out.println();

        System.out.println("---- autocomplete ----");
        System.out.println(trie.allWordsWithPrefix("a"));
        System.out.println(trie.allWordsWithPrefix("ai"));

        trie.insert("doubles", 6);
        trie.insert("yoon", 7);
        trie.insert("kim", 8);
        trie.insert("park", 9);
        trie.insert("lee", 10);
        trie.insert("choi", 11);

        System.out.println();
        
        System.out.println("---- sort ----");
        // 정렬
        List<String> list = trie.allWordsWithPrefix("");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
