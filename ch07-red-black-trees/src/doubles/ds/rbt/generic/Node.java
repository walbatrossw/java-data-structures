package doubles.ds.rbt.generic;

public class Node<T> {

    private T data;                 // 노드 데이터
    private NodeColor color;        // 노드 컬러
    private Node<T> leftChildNode;  // 왼쪽 자식노드
    private Node<T> rightChildNode; // 오른쪽 자식노드
    private Node<T> parentNode;     // 부모노드

    public Node(T data) {
        this.data = data;
        this.color = NodeColor.RED; // 기본값은 레드
    }

    // getter, setter, toString()
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeColor getColor() {
        return color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }

    public Node<T> getLeftChildNode() {
        return leftChildNode;
    }

    public void setLeftChildNode(Node<T> leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public Node<T> getRightChildNode() {
        return rightChildNode;
    }

    public void setRightChildNode(Node<T> rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    public Node<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node<T> parentNode) {
        this.parentNode = parentNode;
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}
