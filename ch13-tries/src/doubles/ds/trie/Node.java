package doubles.ds.trie;

public class Node {

    private String character;   //  알파벳 문자
    private Node[] children;    //  하위 노드 배열 변수
    private boolean leaf;       //  leaf 노드 여부 확인
    private boolean visited;    //  탐색 여부

    // 생성자
    public Node(String character) {
        this.character = character;     // 알파벳
        this.children = new Node[Constants.ALPHABET_SIZE];
    }

    // getter, setter

    public Node getChild(int index) {
        return children[index];
    }

    public void setChild(int index, Node node) {
        this.children[index] = node;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return this.character;
    }
}
