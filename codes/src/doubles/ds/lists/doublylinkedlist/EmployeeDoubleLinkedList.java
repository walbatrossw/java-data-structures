package doubles.ds.lists.doublylinkedlist;

import doubles.ds.Employee;

public class EmployeeDoubleLinkedList {

    private EmployeeDoubleNode head;
    private EmployeeDoubleNode tail;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeDoubleNode node = new EmployeeDoubleNode(employee);
        node.setNext(head);

        if (head == null) {
            tail = node;
        } else {
            head.setPrev(node);
        }

        head = node;
        size++;
    }

    public void addToEnd(Employee employee) {
        EmployeeDoubleNode node = new EmployeeDoubleNode(employee);
        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
        size++;
    }

    // 연결리스트 첫노드 삭제
    public EmployeeDoubleNode removeFormFront() {
        if (isEmpty())
            return null;
        EmployeeDoubleNode removedNode = head;
        head = head.getNext();
        removedNode.setNext(null);
        size--;
        return removedNode;
    }

    // 연결리스트 사이즈
    public int getSize() {
        return size;
    }

    // 연결 리스트 공백확인
    public boolean isEmpty() {
        return head == null;
    }

    // 연결 리스트 출력
    public void printList() {
        EmployeeDoubleNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
