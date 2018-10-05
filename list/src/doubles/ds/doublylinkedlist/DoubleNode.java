package doubles.ds.doublylinkedlist;

public class DoubleNode<E> {

    private E item;
    private DoubleNode<E> nextNode;
    private DoubleNode<E> prevNode;

    public DoubleNode(E item, DoubleNode<E> nextNode, DoubleNode<E> prevNode) {
        this.item = item;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public DoubleNode<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleNode<E> nextNode) {
        this.nextNode = nextNode;
    }

    public DoubleNode<E> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(DoubleNode<E> prevNode) {
        this.prevNode = prevNode;
    }

}
