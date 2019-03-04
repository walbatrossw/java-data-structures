package doubles.ds.trie;

public class Node {

    private String character;
    private Node[] children;
    private boolean leaf;
    private boolean visited;

    public Node(String character) {
        this.character = character;
        this.children = new Node[Constants.ALPHABET_SIZE];
    }

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
}
