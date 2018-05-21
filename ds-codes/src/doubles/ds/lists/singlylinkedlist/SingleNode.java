package doubles.ds.lists.singlylinkedlist;

public class SingleNode<T> {

    private T data; // 노드의 데이터
    private SingleNode<T> nextNode; // 다음 노드

    // 생성자
    public SingleNode(T data) {
        this.data = data;
        this.nextNode = null;
    }

    public SingleNode(T data, SingleNode<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    // Getter, Setter
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SingleNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(SingleNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    // toString
    @Override
    public String toString() {
        return this.data.toString();
    }
}
