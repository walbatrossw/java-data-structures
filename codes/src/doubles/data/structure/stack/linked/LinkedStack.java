package doubles.data.structure.stack.linked;

import doubles.data.structure.stack.Stack;

public class LinkedStack implements Stack {

    private StackNode top;

    @Override
    public boolean isEmpty() {
        return (top == null);
    }

    @Override
    public void push(char item) {
        StackNode newNode = new StackNode();
        newNode.data = item;
        newNode.link = top;
        top = newNode;
        System.out.println("Inserted Item : " + item);
    }

    @Override
    public char pop() {
        if (isEmpty()) {
            System.out.println("LinkedStack is empty...");
            return 0;
        }
        char item = top.data;
        top = top.link;
        return item;
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            System.out.println("LikedStack is empty...");
        }
        top = top.link;
    }

    @Override
    public char peek() {
        if (isEmpty()) {
            System.out.println("LikedStack is empty...");
            return 0;
        }
        return top.data;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("LikedStack is empty...");
            return;
        }
        StackNode temp = top;
        System.out.println("---- Linked Stack ---- ");
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.link;
        }
        System.out.println("---- Linked Stack ---- ");
    }
}
