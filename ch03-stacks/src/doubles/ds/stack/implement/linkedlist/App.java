package doubles.ds.stack.implement.linkedlist;

public class App {
    public static void main(String[] args) {

        Stack<String> myStack = new Stack<>();

        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");

        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());

    }
}
