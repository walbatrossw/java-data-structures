package doubles.ds.linkedlist.question.reverselinkedlist;

// 노드 클래스
public class Node<T extends Comparable<T>> {

    private T data;             // 데이터
    private Node<T> nextNode;   // 다음 노드

    // Getter, Setter, toString 메서드
    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

}
