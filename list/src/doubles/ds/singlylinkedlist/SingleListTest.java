package doubles.ds.singlylinkedlist;

public class SingleListTest {
    public static void main(String[] args) {
        SingleList<String> singleList = new SingleList<>();
        singleList.insertFirst("a");
        singleList.insertFirst("b");
        singleList.insertFirst("c");
        System.out.println(singleList.search("a"));
        singleList.printList();
    }
}
