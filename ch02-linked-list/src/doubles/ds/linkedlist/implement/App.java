package doubles.ds.linkedlist.implement;

// 리스트 테스트 클래스
public class App {
    public static void main(String[] args) {
        List<String> myLinkedList = new LinkedList<>();

        myLinkedList.insert("A");
        myLinkedList.insert("B");
        myLinkedList.insert("C");
        myLinkedList.insert("D");

        System.out.println(myLinkedList.size());
        myLinkedList.traverseList();

        myLinkedList.remove("D");
        myLinkedList.traverseList();

        myLinkedList.remove("A");
        myLinkedList.traverseList();
    }
}
