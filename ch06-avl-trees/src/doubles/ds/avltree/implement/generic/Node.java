package doubles.ds.avltree.implement.generic;

public class Node<T> {

    private T data;                 // 데이터
    private Node<T> leftNode;       // 왼쪽 하위노드
    private Node<T> rightNode;      // 오른쪽 하위노드
    private int height;             // 높이

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
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
        return this.data.toString();
    }

}
