package doubles.ds.bst.question.comparetrees;

public class Node<T> {

    private T data;             // 노드 데이터
    private Node<T> leftChild;  // 왼쪽 하위 노드
    private Node<T> rightChild; // 오른쪽 하위 노드

    // 생성자
    public Node(T data) {
        this.data = data;
    }

    // getter, setter, toString()
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
