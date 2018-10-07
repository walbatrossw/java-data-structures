package doubles.ds.arrays.arraylist;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
//        list.peek(0);
//        list.delete(0);

        list.addLast("b");
        list.addLast("c");
        list.printList();

        list.addLast("e");
        list.printList();

        list.addLast("f");
        list.addLast("g");
        list.printList();

        list.addFirst("a");
        list.add("d", 3);
        list.printList();

        list.removeFirst(); // a 제거
        list.removeLast();  // g 제거
        list.remove(1); // c 제거
        list.printList();

        list.removeLast();  // f 제거
        list.removeLast();  // e 제거
        list.printList();
    }
}
