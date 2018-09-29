package doubles.ds.singlylinkedlist;

public class SingleListTest {
    public static void main(String[] args) {
        SingleList<String> list = new SingleList<>();

        list.addFirst("a");
        list.add("b", 0);
        list.add("c", 0);
        list.add("d", 3);
        list.addLast("e");
        list.addLast("f");
        list.printList();

        list.removeFirst();
        list.printList();

        list.remove(2);
        list.printList();

        list.removeLast();
        list.printList();

        System.out.println(list.peek(1));
    }
}
