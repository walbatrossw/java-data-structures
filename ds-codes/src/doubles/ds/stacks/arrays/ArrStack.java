package doubles.ds.stacks.arrays;

import java.util.EmptyStackException;

public class ArrStack<T> {

    private T[] arr;
    private int top;

    public ArrStack() {
        this.arr = (T[]) new Object[1];
        this.top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    // peek
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return arr[top];
    }

    // push
    public void push(T newData) {
        if (size() == arr.length) {
            resize(2 * arr.length);
        }
        arr[++top] = newData;
    }

    // pop
    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        T item = arr[top];
        arr[top--] = null;
        if (size() > 0 && size() == arr.length / 4) {
            resize(arr.length/2);
        }
        return item;
    }

    // resize
    private void resize(int newSize) {
        Object[] newArr = new Object[newSize];
        for (int i = 0; i < top + 1; i++) {
            newArr[i] = arr[i];
        }
        arr = (T[]) newArr;
    }

    @Override
    public String toString() {
        String text = "[";
        for (int i = 0; i < top+1; i++) {
            text += arr[i];
            if (i < top+1 - 1)
                text += ",";
        }
        return text + "]";
    }
}
