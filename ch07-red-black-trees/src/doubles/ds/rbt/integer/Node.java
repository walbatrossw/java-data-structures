package doubles.ds.rbt.integer;

public class Node {

    private int data;           // 데이터
    private NodeColor color;    // 노드컬러
    private Node leftNode;      // 왼쪽 자식노드
    private Node rightNode;     // 오른쪽 자식노드
    private Node parentNode;    // 부모노드

    public Node(int data) {
        this.data = data;
        this.color = NodeColor.RED; // 기본값은 레드
    }

    // Getter, Setter
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeColor getColor() {
        return color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
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

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}
