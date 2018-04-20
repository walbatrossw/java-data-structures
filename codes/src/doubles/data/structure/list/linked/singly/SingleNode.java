package doubles.data.structure.list.linked.singly;

public class SingleNode<T> {

    private T data;
    private SingleNode<T> nextNode;

    public SingleNode(T data, SingleNode<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

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
}
