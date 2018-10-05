package doubles.ds.doublylinkedlist;

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("c");
        list.printList();
    }
}
