package doubles.ds.lists.singlylinkedlist;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        // 첫번째 추가
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.addFirst("D");

        // 마지막 추가
        list.addLast("AA");

        // 특정 인덱스에 추가
        list.add("BB", 4);

        // 연결리스트 출력
        list.printList();

        // 특정 인덱스의 데이터
        System.out.println(list.get(1));

        // 특정 인덱스의 노드
        System.out.println(list.getNode(1));

        // 연결리스트의 사이즈
        System.out.println(list.getSize());

        // 특정 데이터의 인덱스
        System.out.println(list.indexOf("AA"));

        list.removeLast();
    }
}
