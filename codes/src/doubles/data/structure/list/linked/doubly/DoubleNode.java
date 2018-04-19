package doubles.data.structure.list.linked.doubly;

public class DoubleNode<E> {
    private E item;
    private DoubleNode previous;
    private DoubleNode next;

    public DoubleNode(E item, DoubleNode previous, DoubleNode next) {
        this.item = item;
        this.previous = previous;
        this.next = next;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public DoubleNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}
