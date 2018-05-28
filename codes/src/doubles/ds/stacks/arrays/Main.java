package doubles.ds.stacks.arrays;

public class Main {
    public static void main(String[] args) {
        ArrStack<String> stack = new ArrStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
