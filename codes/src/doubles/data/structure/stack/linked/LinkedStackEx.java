package doubles.data.structure.stack.linked;

public class LinkedStackEx {

    public static void main(String[] args) {

        char deletedItem;
        LinkedStack linkedStack = new LinkedStack();

        linkedStack.push('D');
        linkedStack.push('L');
        linkedStack.push('R');
        linkedStack.push('O');
        linkedStack.push('W');
        linkedStack.push('O');
        linkedStack.push('L');
        linkedStack.push('L');
        linkedStack.push('E');
        linkedStack.push('H');
        linkedStack.printStack();

        for (int i = 0; i <= 4; i++) {
            deletedItem = linkedStack.pop();
            if (deletedItem != 0)
                System.out.println("Deleted Item : " + deletedItem);
            linkedStack.printStack();
        }

    }

}
