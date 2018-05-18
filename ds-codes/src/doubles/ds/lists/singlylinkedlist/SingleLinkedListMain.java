package doubles.ds.lists.singlylinkedlist;

public class SingleLinkedListMain {
    public static void main(String[] args) {
        SingleLinkedList<String> stringList = new SingleLinkedList<>();
        stringList.addFirst("B");
        stringList.addFirst("D");
        stringList.addFirst("E");
        stringList.addFirst("F");

        stringList.printLinkedList();
        stringList.addAfter("C", stringList.getNode(3));
        stringList.addLast("A");

        stringList.printLinkedList();
    }
}
