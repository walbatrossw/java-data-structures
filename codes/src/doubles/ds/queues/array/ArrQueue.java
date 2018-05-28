package doubles.ds.queues.array;

import java.util.NoSuchElementException;

public class ArrQueue<T> {

    private T[] queueArr;
    private int front;
    private int rear;
    private int size;

    public ArrQueue() {
        this.queueArr = (T[]) new Object[2];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T newData) {
        if ((rear + 1) % queueArr.length == front) {
            resize(2 * queueArr.length);
        }
        rear = (rear + 1) % queueArr.length;
        queueArr[rear] = newData;
        size++;
    }

    public T remove() {
        if (isEmpty())
            throw new NoSuchElementException();
        front = (front + 1) % queueArr.length;
        T data = queueArr[front];
        queueArr[front] = null;
        size--;
        if (size > 0 && size == queueArr.length / 4) {
            resize(queueArr.length / 2);
        }
        return data;
    }

    public void resize(int newSize) {
        Object[] newArr = new Object[newSize];
        for (int i = 1, j = front + 1; i < size + 1; i++, j++) {
            newArr[i] = queueArr[j % queueArr.length];
        }
        front = 0;
        rear = size;
        queueArr = (T[]) newArr;
    }

    public void printQueue() {
        for (int i = front; i < rear; i++) {
            System.out.print(queueArr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
