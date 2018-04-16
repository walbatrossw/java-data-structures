package doubles.data.structure.stack.orderd;

import doubles.data.structure.stack.Stack;

public class ArrayStack implements Stack {

    private int top;
    private int stackSize;
    private char itemArray[];

    public ArrayStack(int stackSize){
        top = -1;
        this.stackSize = stackSize;
        itemArray = new char[this.stackSize];
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    private boolean isFull() {
        return (top == this.stackSize-1);
    }

    @Override
    public void push(char item) {
        if (isFull()) {
            System.out.println("ArrayStack is full...");
            return;
        }

        itemArray[++top] = item;
        System.out.println("Inserted Item : " + item);
    }

    @Override
    public char pop() {
        if (isEmpty()) {
            System.out.println("ArrayStack is empty...");
            return 0;
        }

        return itemArray[top--];
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            System.out.println("ArrayStack is empty...");
            return;
        }
        top--;
    }

    @Override
    public char peek() {
        if (isEmpty()) {
            System.out.println("ArrayStack is empty...");
            return 0;
        }
        return itemArray[top];
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("ArrayStack is Empty...");
            return;
        }
        System.out.println("---- ArrayStack -----");
        for (int i = top; 0 <= i ; i--) {
            System.out.println(itemArray[i]);
        }
        System.out.println("---- ArrayStack -----");
    }
}
