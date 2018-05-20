package doubles.ds.lists.singlylinkedlist;

import java.util.NoSuchElementException;

public class SingleLinkedList<T> {

    private SingleNode<T> head;
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // 연결리스트의 특정 데이터의 노드 인덱스 반환
    public int indexOf(T data) {

        SingleNode<T> node = head;

        int index = 0;

        while (!node.getData().equals(data)) {
            node = node.getNext();
            index++;
            if (node == null) {
                return -1;
            }
        }

        return index;
    }

    // 연결리스트의 특정 인덱스의 데이터 반환
    public T get(int index) {
        SingleNode<T> node = getNode(index);
        return node.getData();
    }

    // 연결리스트의 특정 인덱스 노드 반환
    public SingleNode<T> getNode(int index) {

        SingleNode<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    // 연결리스트의 첫 노드에 새로운 노드 추가
    public void addFirst(T newData) {

        head = new SingleNode<>(newData, head);
        size++;

    }

    // 연결리스트의 특정 인데스에 새로운 노드 추가
    public void add(T newData, int index) {

        // 연결리스트가 공백이면
        if (isEmpty()) {
            addFirst(newData);
            return;
        }

        // 특정 인덱스의 이전 노드
        SingleNode prev = getNode(index - 1);

        // 새로운 노드
        SingleNode<T> newNode = new SingleNode<>(newData, prev.getNext());

        // 이전노드의 다음노드에 새로운 노드를 추가
        prev.setNext(newNode);
        size++;
    }

    // 연결리스트의 마지막에 새로운 노드 추가
    public void addLast(T newData) {

        // 연결리스트가 공백이면
        if (isEmpty()) {
            addFirst(newData);
            return;
        }

        // 마지막 노드까지 탐색
        SingleNode<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        // 마지막 노드에 새로운 노드를 추가
        SingleNode<T> newNode = new SingleNode<>(newData);
        current.setNext(newNode);
        size++;
    }

    // 연결리스트의 첫번째 노드 제거
    public T removeFirst() {

        // 연결리스트가 공백이면
        if (isEmpty())
            throw new NoSuchElementException();

        SingleNode<T> removeToNode = head;
        head = head.getNext();
        removeToNode.setNext(null);
        size--;

        return removeToNode.getData();
    }

    // 연결리스트의 특정 인덱스 노드 제거
    public T remove(int index) {

        // 연결리스트가 공백이면
       if (isEmpty())
            throw  new NoSuchElementException();

        // 특정 인덱스의 이전 노드
        SingleNode<T> prev = getNode(index - 1);
        // 삭제할 노드
        SingleNode<T> nodeToRemove = prev.getNext();

        // 이전 노드의 다음노드를 삭제할 노드의 다음 노드로 변경
        prev.setNext(nodeToRemove.getNext());

        size--;

        return nodeToRemove.getData();
    }

    // 연결리스트의 마지막 노드 제거
    public T removeLast() {
        return remove(size - 1);
    }

    // 연결리스트의 사이즈 반환
    public int getSize() {
        return size;
    }

    // 연결리스트 공백 확인
    private boolean isEmpty() {
        return head == null;
    }

    // 연결리스트의 전체 탐색한 내용 출력
    public void printList() {

        System.out.print("HEAD -> ");
        SingleNode current = head;
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");

    }

}
