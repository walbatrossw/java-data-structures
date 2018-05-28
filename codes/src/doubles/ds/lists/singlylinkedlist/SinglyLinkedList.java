package doubles.ds.lists.singlylinkedlist;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {

    private SingleNode<T> head; // 연결리스트의 첫번째 노드
    private int size;   // 연결리스트의 사이즈

    // 연결리스트 생성자
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // 노드 추가 : 맨 앞
    public void addFirst(T newData) {
        head = new SingleNode<>(newData, head);
        size++;
    }

    // 노드 추가 : 특정 인덱스에
    public void add(T newData, int index) {
        if (isEmpty()) {
            addFirst(newData);
            return;
        }
        SingleNode<T> prevNode = getNode(index - 1);
        SingleNode<T> newNode = new SingleNode<>(newData, prevNode.getNextNode());
        prevNode.setNextNode(newNode);
        size++;
    }

    // 노드 추가 : 맨 뒤
    public void addLast(T newData) {
        SingleNode<T> newNode = new SingleNode<>(newData);
        if (isEmpty()) {
            addFirst(newData);
            return;
        }
        SingleNode<T> lastNode = getNode(size - 1);
        lastNode.setNextNode(newNode);
        size++;
    }

    // 노드 삭제 : 맨 앞
    public T removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        SingleNode<T> nodeToRemove = head;
        head = head.getNextNode();
        nodeToRemove.setNextNode(null);
        size--;
        return nodeToRemove.getData();
    }

    // 노드 삭제 : 특정 인덱스
    public T remove(int index) {
        if (isEmpty())
            throw new NoSuchElementException();
        if (index == 0)
            return removeFirst();
        SingleNode<T> prevNode = getNode(index - 1);
        SingleNode<T> nodeToRemove = prevNode.getNextNode();
        prevNode.setNextNode(nodeToRemove.getNextNode());
        nodeToRemove.setNextNode(null);
        size--;
        return nodeToRemove.getData();
    }

    // 노드 삭제 : 맨 뒤
    public T removeLast() {
        return remove(size - 1);
    }

    // 노드 반환 : 특정 인덱스
    private SingleNode<T> getNode(int index) {
        SingleNode<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node;
    }

    // 노드 데이터 반환 : 특정 인덱스
    public T getData(int index) {
        SingleNode<T> node = getNode(index);
        return node.getData();
    }

    // 노드 인덱스 반환 : 특정 데이터
    public int indexOf(T data) {
        SingleNode<T> node = head;
        int index = 0;
        while (!node.getData().equals(data)) {
            node = node.getNextNode();
            index++;
            if (node == null)
                return -1;
        }
        return index;
    }

    // 연결리스트 공백 여부 확인
    private boolean isEmpty() {
        return this.head == null;
    }

    // 연결리스트 사이즈
    public int getSize() {
        return this.size;
    }

    // 연결리스트 전체 탐색 결과 출력
    public void printList() {
        System.out.print("HEAD ==> ");
        SingleNode<T> current = head;
        while (current != null) {
            System.out.print(current);
            System.out.print(" ==> ");
            current = current.getNextNode();
        }
        System.out.println("NULL");
    }

}
