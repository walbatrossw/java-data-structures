package doubles.ds.lists.singlylinkedlist;

public class SingleNode<T> {

    private T data;
    private SingleNode<T> next;

    // Constructor

    public SingleNode() {
        this.data = null;
        this.next = null;
    }

    public SingleNode(T data) {
        this.data = data;
        this.next = null;
    }

    public SingleNode(T data, SingleNode<T> next) {
        this.data = data;
        this.next = next;
    }

    // Getter, Setter, toString()

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
