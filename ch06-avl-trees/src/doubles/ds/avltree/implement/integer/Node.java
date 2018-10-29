package doubles.ds.avltree.implement.integer;

public class Node {

    private int data;           // 데이터
    private Node leftNode;      // 왼쪽 하위 노드
    private Node rightNode;     // 오른쪽 하위 노드
    private int height;         // 높이

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return ""+ this.data;
    }
}
