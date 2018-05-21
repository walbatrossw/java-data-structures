package doubles.ds.lists.doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<String> grades = new DoublyLinkedList<>();

        // 첫노드 추가
        grades.addFirst("A");
        grades.addFirst("B");
        grades.addFirst("C");
        // 연결리스트 출력
        grades.printList();
        // 연결리스트 역방향 출력
        grades.reversePrintList();

        // 마지막 노드 추가
        grades.addLast("A+");
        grades.printList();

        grades.addLast("A++");
        grades.printList();

        // 특정 인덱스에 노드 추가
        grades.add("C+" , 1);
        grades.printList();

        grades.add("C++" , 2);
        grades.printList();

        grades.add("B+" , 4);
        grades.printList();

        grades.add("B++" , 5);
        grades.printList();

        // 첫노드 제거
        System.out.println(grades.removeFirst());
        System.out.println(grades.removeFirst());
        grades.printList();

        // 특정 인덱스 노드 제거
        System.out.println(grades.remove(5));
        System.out.println(grades.remove(1));
        System.out.println(grades.remove(2));
        grades.printList();

        // 마지막 노드 제거
        System.out.println(grades.removeLast());
        System.out.println(grades.removeLast());
        grades.printList();

        // 특정 데이터의 인덱스 
        System.out.println(grades.indexOf("B+"));
        System.out.println(grades.indexOf("A"));

    }
}
