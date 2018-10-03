package doubles.ds.doublylinkedlist;

public class DoubleList<E> {

    private DoubleNode<E> head;
    private int size;

    public DoubleList() {
        this.head = new DoubleNode<>(null);
        size = 0;
    }
}
