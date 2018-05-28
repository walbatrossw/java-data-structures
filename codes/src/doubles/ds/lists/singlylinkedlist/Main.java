package doubles.ds.lists.singlylinkedlist;

public class Main {
    public static void main(String[] args) {

        SinglyLinkedList<String> stringList = new SinglyLinkedList<>();

        stringList.addFirst("C");
        stringList.addFirst("B");
        stringList.addFirst("A");
        stringList.printList();
        System.out.println("size : " + stringList.getSize());

        stringList.addLast("D");
        stringList.addLast("F");
        stringList.printList();
        System.out.println("size : " + stringList.getSize());


        stringList.add("E", 4);
        stringList.printList();
        System.out.println("size : " + stringList.getSize());

        System.out.println("removed : " + stringList.removeFirst());
        stringList.printList();

        System.out.println("removed : " + stringList.remove(2));
        stringList.printList();

        System.out.println("removed : " + stringList.removeLast());
        stringList.printList();

    }
}
