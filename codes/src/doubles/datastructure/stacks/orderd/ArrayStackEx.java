package doubles.datastructure.stacks.orderd;

public class ArrayStackEx {
    public static void main(String[] args) {
        int stackSize = 10;
        char deletedItem;
        ArrayStack arrayStack = new ArrayStack(stackSize);

        arrayStack.push('D');
        arrayStack.push('L');
        arrayStack.push('R');
        arrayStack.push('O');
        arrayStack.push('W');
        arrayStack.push('O');
        arrayStack.push('L');
        arrayStack.push('L');
        arrayStack.push('E');
        arrayStack.push('H');
        arrayStack.printStack();

        for (int i = 0; i < 5; i++) {
            deletedItem = arrayStack.pop();
            if (deletedItem != 0)
                System.out.println("Deleted Item : " + deletedItem);
            arrayStack.printStack();
        }

    }
}
