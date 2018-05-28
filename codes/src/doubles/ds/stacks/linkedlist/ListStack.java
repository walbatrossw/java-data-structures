package doubles.ds.stacks.linkedlist;

import java.util.EmptyStackException;

public class ListStack<T> {

    private Node<T> top;
    private int size;

    public ListStack() {
        this.top = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return top.getData();
    }

    public void push(T newData) {
        top = new Node<>(newData, top);
        size++;
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        T topData = top.getData();
        size--;
        return topData;
    }

    public void printListStack() {
        System.out.println("===TOP===");
        Node<T> current = top;
        while (current != null) {
            System.out.println(current);
            current = current.getNextNode();
        }
    }
}
