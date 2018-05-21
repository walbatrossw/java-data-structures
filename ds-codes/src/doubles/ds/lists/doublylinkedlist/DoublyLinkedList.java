package doubles.ds.lists.doublylinkedlist;

public class DoublyLinkedList<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size = 0;

    // 노드 추가 : 맨 앞
    public void addFirst(T newData) {
        DoubleNode<T> newNode = new DoubleNode<>(newData);
        if (head == null) {
            tail = newNode;
        } else {
            head.setPrevNode(newNode);
            newNode.setNextNode(head);
        }
        head = newNode;
        size++;
    }

    // 노드 추가 : 특정 인덱스
    public void add(T newData, int index) {
        if (index == 0) {
            addFirst(newData);
            return;
        }

        DoubleNode<T> newNode = new DoubleNode<>(newData);
        DoubleNode<T> node = getNode(index);
        DoubleNode<T> prevNode = node.getPrevNode();

        prevNode.setNextNode(newNode);
        newNode.setNextNode(node);

        size++;

        if (newNode.getNextNode() == null) {
            tail = newNode;
        }
    }

    // 노드 추가 : 맨 뒤
    public void addLast(T newData) {
        DoubleNode<T> newNode = new DoubleNode<>(newData);
        if (isEmpty()) {
            addFirst(newData);
            return;
        }
        tail.setNextNode(newNode);
        newNode.setPrevNode(tail);
        tail = newNode;
        size++;
    }

    public T removeFirst() {
        DoubleNode<T> nodeToRemove = head;
        head = nodeToRemove.getNextNode();
        T returnValue = nodeToRemove.getData();
        nodeToRemove = null;
        size--;
        return returnValue;
    }

    public T remove(int index) {
        if (index == 0) {
            return removeFirst();
        }

        return null;
    }

    public T removeLast() {
        return null;
    }

    private DoubleNode<T> getNode(int index) {
        DoubleNode<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node;
    }

    // 노드 인덱스 반환 : 특정 데이터
    public int indexOf(T data) {
        DoubleNode<T> node = head;
        int index = 0;
        while (!node.getData().equals(data)) {
            node = node.getNextNode();
            index++;
            if (node == null) {
                return -1;
            }
        }
        return index;
    }

    // 연결리스트 공백 여부 확인
    private boolean isEmpty() {
        return this.head == null;
    }

    // 연결리스트 사이즈 반환
    public int getSize() {
        return this.size;
    }

    // 연결리스트 전체 탐색 결과 출력
    public void printList() {
        System.out.print("HEAD ==> ");
        DoubleNode<T> current = head;
        while (current != null) {
            System.out.print(current);
            System.out.print(" <==> ");
            current = current.getNextNode();
        }
        System.out.println("NULL");
    }

}
