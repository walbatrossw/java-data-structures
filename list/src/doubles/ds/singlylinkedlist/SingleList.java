package doubles.ds.singlylinkedlist;

public class SingleList<E> {

    private Node<E> head;
    private int size;

    public SingleList() {
        this.head = null;
        this.size = 0;
    }

    // 데이터 탐색 결과 반환 : 특정 인덱스
    public Node<E> peek(int index) {
        return getNode(index);
    }

    // 데이터 탐색 : 특정 인덱스
    private Node<E> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node;
    }

    // 데이터 삽입 : 첫번째
    public void addFirst(E newItem) {
        head = new Node<>(newItem, head);
        size++;
    }

    // 데이터 삽입 : 특정 인덱스
    public void add(E newItem, int index) {
        if (index == 0) {
            addFirst(newItem);
            return;
        }
        Node<E> preNode = getNode(index - 1);   // 삽입할 index 이전 노드
        Node<E> nextNode = preNode.getNextNode();     // 삽입할 index 다음 노드
        Node<E> newNode = new Node<>(newItem, nextNode);    // 삽입할 노드
        preNode.setNextNode(newNode);
        size++;
    }

    // 데이터 삽입 : 마지막
    public void addLast(E newItem) {
        add(newItem, size - 1);
    }

    // 데이터 삭제 : 첫번째
    public void removeFirst() {
        head = head.getNextNode();
        size--;
    }

    // 데이터 삭제 : 특정 인덱스
    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            removeFirst();
            return;
        }
        Node<E> preNode = getNode(index - 1);
        Node<E> nodeToRemove = preNode.getNextNode();
        Node<E> nextNode = nodeToRemove.getNextNode();
        preNode.setNextNode(nextNode);
        size--;
    }

    // 데이터 삭제 : 마지막
    public void removeLast() {
        remove(size - 1);
    }

    // 리스트 사이즈 반환
    public int getSize() {
        return size;
    }

    // 리스트 데이터 출력
    public void printList() {
        Node<E> p = head;
        for (int i = 0; i < size; i++) {
            System.out.print(p + "");
            p = p.getNextNode();
        }
        System.out.println();
    }

}
