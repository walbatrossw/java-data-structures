package doubles.ds.doublylinkedlist;

public class DoubleNode<E> {

    private E item;
    private DoubleNode<E> prevNode;
    private DoubleNode<E> nextNode;

    public DoubleNode(E item) {
        this.item = item;
        this.prevNode = null;
        this.nextNode = null;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public DoubleNode<E> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(DoubleNode<E> prevNode) {
        this.prevNode = prevNode;
    }

    public DoubleNode<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleNode<E> nextNode) {
        this.nextNode = nextNode;
    }
}
