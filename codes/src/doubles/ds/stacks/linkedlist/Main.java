package doubles.ds.stacks.linkedlist;

public class Main {
    public static void main(String[] args) {
        ListStack<String> listStack = new ListStack<>();
        listStack.push("A");
        listStack.push("B");
        listStack.push("C");
        listStack.push("D");
        listStack.push("E");

        System.out.println(listStack.peek());
        System.out.println(listStack.pop());
        listStack.printListStack();
    }
}
