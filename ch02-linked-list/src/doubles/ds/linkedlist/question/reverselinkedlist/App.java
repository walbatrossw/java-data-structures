package doubles.ds.linkedlist.question.reverselinkedlist;

// 리스트 테스트 클래스
public class App {
    public static void main(String[] args) {
        List<String> myLinkedList = new LinkedList<>();

        myLinkedList.insert("A");
        myLinkedList.insert("B");
        myLinkedList.insert("C");
        myLinkedList.insert("D");
        myLinkedList.insert("E");
        myLinkedList.insert("F");
        myLinkedList.insert("G");
        myLinkedList.insert("H");
        myLinkedList.traverseList();
        myLinkedList.reverse();
        myLinkedList.traverseList();
    }
}
