package doubles.ds.trie;

import java.util.List;

public class Trie {

    private Node root;
    private int indexOfSingleChild;

    public Trie() {
        this.root = new Node("");
    }

    // 삽입
    public void insert() {

    }

    // 탐색
    public boolean search(String key) {
        return false;
    }

    public List<String> allWordsWithPrefix(String prefix) {
        return null;
    }

    public String longestCommonPrefix() {
        return null;
    }

    private int countNumOfChildren(Node trieNode) {
        return 0;
    }

    private void collect(Node node, String prefix, List<String> allWords) {

    }

}
