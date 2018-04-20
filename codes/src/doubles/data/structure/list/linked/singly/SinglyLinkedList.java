package doubles.data.structure.list.linked.singly;

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class SinglyLinkedList<T> {

    protected SingleNode head;  // 연결리스트의 첫 노드
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    // 탐색
    public int search(T target) {
        SingleNode tempNode = head;
        for (int i = 0; i < size; i++) {
            if (target == tempNode.getData())
                return i;
        }
        return -1;
    }

    // 추가 : 맨 앞에 새 노드 추가
    public void add(T data) {
        // 새로운 노드를 첫 노드
        head = new SingleNode(data, head);
        size++;
    }

    // 추가
    public void add(T data, SingleNode node) {
        node.setNextNode(new SingleNode(data, node.getNextNode()));
        size++;
    }

    // 삭제

}
