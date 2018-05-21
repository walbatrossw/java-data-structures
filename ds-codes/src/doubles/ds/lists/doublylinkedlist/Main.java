package doubles.ds.lists.doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<String> stringList = new DoublyLinkedList<>();
        stringList.addFirst("A");
        stringList.addFirst("B");
        stringList.addFirst("C");
        stringList.addLast("AA");
        stringList.addLast("AAA");
        stringList.printList();

        stringList.add("BB" , 2);

        stringList.printList();
    }
}
