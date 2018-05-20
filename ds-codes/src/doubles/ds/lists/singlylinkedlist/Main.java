package doubles.ds.lists.singlylinkedlist;

public class Main {
    public static void main(String[] args) {

        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        // 첫번째 노드 추가
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        // 마지막 노드 추가
        list.addLast(5);

        // 특정 인덱스에 노드 추가
        list.add(6, 5);

        // 연결리스트 출력
        list.printList();

        // 특정 인덱스 노드의 데이터
        System.out.println(list.get(1));

        // 특정 인덱스의 노드
        System.out.println(list.getNode(1));

        // 연결리스트의 사이즈
        System.out.println(list.getSize());

        // 특정 데이터의 인덱스
        System.out.println(list.indexOf(1));

        // 첫번째 노드 삭제
        System.out.println(list.removeFirst());

        list.printList();

        // 특정 인덱스의 노드 제거
        System.out.println(list.remove(2));

        list.printList();

        // 마지막 노드 제거
        System.out.println(list.removeLast());

        list.printList();

    }
}
