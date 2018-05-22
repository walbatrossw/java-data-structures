package doubles.ds.stacks.linkedlist;

public class Node<T> {

    private T data;
    private Node<T> nextNode;

    public Node(T data) {
        this.data = data;
        this.nextNode = null;
    }

    public Node(T data, Node<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
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
