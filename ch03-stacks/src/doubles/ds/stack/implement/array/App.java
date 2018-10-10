package doubles.ds.stack.implement.array;

public class App {
    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");
        System.out.println("stack size : " + myStack.size());
        System.out.println("stack peek : " + myStack.peek());
        System.out.println("stack pop : " + myStack.pop());
        System.out.println("stack pop : " + myStack.pop());
        System.out.println("stack pop : " + myStack.pop());
        System.out.println("stack peek : " + myStack.peek());
    }
}
