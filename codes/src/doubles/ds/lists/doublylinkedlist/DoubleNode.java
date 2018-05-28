package doubles.ds.lists.doublylinkedlist;

public class DoubleNode<T> {

    private T data;
    private DoubleNode<T> prevNode;
    private DoubleNode<T> nextNode;

    public DoubleNode(T data) {
        this.data = data;
    }

    public DoubleNode(T data, DoubleNode<T> prevNode, DoubleNode<T> nextNode) {
        this.data = data;
        this.prevNode = prevNode;
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleNode<T> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(DoubleNode<T> prevNode) {
        this.prevNode = prevNode;
    }

    public DoubleNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
