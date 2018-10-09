package doubles.ds.linkedlist.question.findmiddlenode;

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
        System.out.println(myLinkedList.getMiddleNode());
    }
}
