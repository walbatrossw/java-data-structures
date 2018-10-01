package doubles.ds.doublylinkedlist;

public class DoubleListTest {
    public static void main(String[] args) {
        DoubleList<String> list = new DoubleList<>();
        list.addFirst("a");
        list.addFirst("b");
        list.printList();
    }
}
