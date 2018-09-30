package doubles.ds.doublylinkedlist;

public class DoubleNode<E> {

    private E item;
    private DoubleNode<E> preNode;
    private DoubleNode<E> nextNode;

    public DoubleNode(E item) {
        this.item = item;
        this.preNode = null;
        this.nextNode = null;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public DoubleNode<E> getPreNode() {
        return preNode;
    }

    public void setPreNode(DoubleNode<E> preNode) {
        this.preNode = preNode;
    }

    public DoubleNode<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleNode<E> nextNode) {
        this.nextNode = nextNode;
    }
}
