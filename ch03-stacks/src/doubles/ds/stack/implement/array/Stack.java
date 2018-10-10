package doubles.ds.stack.implement.array;

public class Stack<T> {

    private T[] stack;
    private int numOfItems;

    public Stack() {
        this.stack = (T[]) new Object[1];
    }
}
