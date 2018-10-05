package doubles.ds.doublylinkedlist;

public class DoubleLinkedList<E> {

    private DoubleNode<E> head;
    private DoubleNode<E> tail;
    private int size;

    public DoubleLinkedList() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E item) {
        DoubleNode<E> newNode = new DoubleNode<>(item, head, null);
        if (head != null) {
            head.setPrevNode(newNode);
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
        System.out.println("adding : " + item);
    }

    

    public void printList() {
        DoubleNode<E> node = head;
        while (node != null) {
            System.out.print(node.getItem());
            System.out.print(" <==> ");
            node = node.getNextNode();
        }
        System.out.println("null");
    }

}
