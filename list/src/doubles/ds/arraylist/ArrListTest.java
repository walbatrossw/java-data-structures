package doubles.ds.arraylist;

public class ArrListTest {
    public static void main(String[] args) {
        ArrList<String> arrList = new ArrList<>();
        arrList.insertFirst("a");
        arrList.printList();
        arrList.insertFirst("b");
        arrList.printList();
        arrList.insertFirst("c");
        arrList.printList();
        arrList.insert("d", 3);
        arrList.printList();
        arrList.insertLast("e");
        arrList.printList();
        arrList.insertLast("f");
        arrList.printList();
        arrList.insertLast("g");

        arrList.printList();

        arrList.delete(0);
        arrList.printList();
        arrList.delete(0);
        arrList.printList();
        arrList.delete(0);
        arrList.printList();
        arrList.delete(0);
        arrList.printList();
        arrList.delete(0);
        arrList.printList();
    }


}
