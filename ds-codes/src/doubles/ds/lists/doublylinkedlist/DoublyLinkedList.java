package doubles.ds.lists.doublylinkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size = 0;

    // 노드 추가 : 맨 앞
    public void addFirst(T newData) {
        DoubleNode<T> newNode = new DoubleNode<>(newData);  //  새로운 노드 생성
        if (head == null) {                                 //  첫노드가 null 인 경우
            tail = newNode;                                 //  마지막 노드를 새로운 노드로
        } else {
            head.setPrevNode(newNode);                      // 새로운 노드를 기존의 첫 노드의 이전 노드로 변경
            newNode.setNextNode(head);                      // 새로운 노드의 다음 노드를 첫 노드로 세팅
        }
        head = newNode;                                     // 첫 노드를 새로운 노드로 변경
        size++;
    }

    // 노드 추가 : 특정 인덱스
    public void add(T newData, int index) {

        // 인덱스가 0이면 첫번째 노드로 추가
        if (index == 0) {
            addFirst(newData);
            return;
        }
        DoubleNode<T> prevNode = getNode(index - 1);     // 특정 인덱스의 이전 노드
        DoubleNode<T> targetNode = prevNode.getNextNode();      // 특정 인덱스 노드
        DoubleNode<T> newNode = new DoubleNode<>(newData);      // 새로운 노드 생성
        prevNode.setNextNode(newNode);                          // 이전 노드의 다음 노드를 새로운 노드로 변경
        newNode.setNextNode(targetNode);                        // 새로운 노드의 다음 노드를 특정 인덱스 노드로 세팅
        if (targetNode != null)                                 // 특정 인덱스 노드의 이전 노드를 새로운 노드로 변경
            targetNode.setPrevNode(newNode);
        newNode.setPrevNode(prevNode);                          // 새로운 노드의 이전 노드를 특정 인덱스의 이전 노드로 세팅
        if (newNode.getNextNode() == null)                      // 새로운 노드가 마지막 노드이면
            tail = newNode;                                     // 마지막 노드를 새로운 노드로 변경

        size++;
    }

    // 노드 추가 : 맨 뒤
    public void addLast(T newData) {
        if (isEmpty()) {        // 연결리스트가 공백이면, 첫번째 노드로 추가
            addFirst(newData);
            return;
        }
        DoubleNode<T> newNode = new DoubleNode<>(newData);  // 새로운 노드 생성
        tail.setNextNode(newNode);                          // 마지막 노드의 다음노드를 새로운 노드로 변경
        newNode.setPrevNode(tail);                          // 새로운 노드의 이전노드를 마지막 노드로 변경
        tail = newNode;                                     // 마지막 노드를 새로운 노드로 변경
        size++;
    }

    // 노드 삭제 : 맨 앞
    public T removeFirst() {
        // 연결리스트가 비어있으면 예외 발생
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        DoubleNode<T> nodeToRemove = head;      // 삭제할 첫번째 노드 저장
        head = nodeToRemove.getNextNode();      // 삭제할 노드의 다음 노드를 head로 저장
        T returnData = nodeToRemove.getData();  // 삭제할 노드의 데이터 저장
        nodeToRemove = null;                    // 삭제할 노드 제거
        if (head != null)                       // 연결리스트가 공백상태가 아니면
            head.setPrevNode(null);             // 첫노드의 이전 노드를 null로 지정
        size--;
        return returnData;
    }

    public T remove(int index) {

        // 연결리스트가 비어있으면 예외 발생
        if (isEmpty())
            throw new NoSuchElementException();
        // 인덱스가 0이면
        if (index == 0)
            return removeFirst();

        DoubleNode<T> prevNode = getNode(index - 1);     // 특정 인덱스 이전 노드
        DoubleNode<T> nodeToRemove = prevNode.getNextNode();    // 삭제할 노드
        DoubleNode<T> nextNode = nodeToRemove.getNextNode();    // 특정 인덱스 다음 노드
        prevNode.setNextNode(nextNode);         // 이전 노드의 다음 노드를 특정 인덱스의 다음 노드로 변경
        if (nextNode != null) {
            nextNode.setPrevNode(prevNode);     // 다음 노드의 이전 노드를 특정 인덱스의 이전 노드로 변경
        }
        T returnData = nodeToRemove.getData();  // 삭제할 노드의 데이터 저장
        if (nodeToRemove.equals(tail)) {        // 삭제할 노드와 마지막 노드가 같으면
            tail = prevNode;                    // 이전노드를 마지막 노드로 저장
        }
        nodeToRemove = null;                    // 삭제할 노드 삭제
        size--;
        return returnData;
    }

    public T removeLast() {
        return remove(size - 1);
    }

    private DoubleNode<T> getNode(int index) {
        // 인덱스가 전체 노드 갯수의 1/2보다 작으면 첫 노드부터 탐색
        if (index < size / 2) {
            DoubleNode<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNextNode();
            }
            return node;
        }
        // 인덱스가 전체 노드 갯수의 1/2보다 크면 마지막 노드부터 탐색
        DoubleNode<T> node = tail;
        for (int i = size - 1; i > index; i--) {
            node = node.getPrevNode();
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
        System.out.print("HEAD --> ");
        DoubleNode<T> current = head;
        while (current != null) {
            System.out.print(current);
            System.out.print(" <==> ");
            current = current.getNextNode();
        }
        System.out.println("NULL");
    }

    // 연결리스트 역순 탐색 결과 출력
    public void reversePrintList() {
        System.out.print("NULL <==> ");
        DoubleNode<T> current = tail;
        while (current != head) {
            System.out.print(current);
            System.out.print(" <==> ");
            current = current.getPrevNode();
        }
        System.out.println("HEAD");
    }

}
