package doubles.data.structure.lists.linked.singly;

public class SingleNode<T> {

    private T data;
    private SingleNode<T> nextNode;

    public SingleNode() {
        this.data = null;
        this.nextNode = null;
    }

    public SingleNode(T data) {
        this.data = data;
        this.nextNode = null;
    }

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

    @Override
    public String toString() {
        return "SingleNode{" +
                "data=" + data +
                ", nextNode=" + nextNode +
                '}';
    }
}
