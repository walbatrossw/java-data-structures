package doubles.ds.singlylinkedlist;

import java.util.NoSuchElementException;

public class SingleList<E> {
    protected Node<E> head;
    private int size;

    public SingleList() {
        this.head = null;
        this.size = 0;
    }

    public int search(E target) {
        Node<E> p = head;
        for (int k = 0; k < size; k++) {
            if (target == p.getItem()) {
                return k;
            }
            p = p.getNextNode();
        }
        return -1;
    }

    public void insertFirst(E newItem) {
        head = new Node<>(newItem, head);
        size++;
    }

    public void insertAfter(E newItem, Node<E> p) {
        p.setNextNode(new Node<>(newItem, p.getNextNode()));
        size++;
    }

    public void printList() {
        Node<E> p = head;
        for (int i = 0; i < size; i++) {
            System.out.print(p + "");
            p = p.getNextNode();
        }
    }

}
