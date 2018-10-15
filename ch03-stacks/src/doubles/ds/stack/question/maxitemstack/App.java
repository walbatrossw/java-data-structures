package doubles.ds.stack.question.maxitemstack;

public class App {
    public static void main(String[] args) {

        MaxItemStack maxItemStack = new MaxItemStack();

        maxItemStack.push(1);
        System.out.println(maxItemStack.getMaxItem());
        maxItemStack.push(2);
        System.out.println(maxItemStack.getMaxItem());
        maxItemStack.push(3);
        System.out.println(maxItemStack.getMaxItem());
        maxItemStack.push(5);
        System.out.println(maxItemStack.getMaxItem());
        maxItemStack.push(4);
        System.out.println(maxItemStack.getMaxItem());
        maxItemStack.push(7);
        System.out.println(maxItemStack.getMaxItem());
        maxItemStack.push(9);
        System.out.println(maxItemStack.getMaxItem());

        System.out.println("-------after pop()-------");

        maxItemStack.pop();
        System.out.println(maxItemStack.getMaxItem());
        maxItemStack.pop();
        System.out.println(maxItemStack.getMaxItem());
        maxItemStack.pop();
        System.out.println(maxItemStack.getMaxItem());
        maxItemStack.pop();
        System.out.println(maxItemStack.getMaxItem());
    }
}
