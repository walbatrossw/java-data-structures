package doubles.ds.lists.siglylinkedlist;

import doubles.ds.Employee;

public class EmployeeLinkedList {

    private EmployeeNode head; // 연결리스트의 첫노드
    private int size; // 연결리스트의 사이즈

    // 연결리스트의 첫노드 삽입
    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public EmployeeNode removeFormFront() {
        if (isEmpty())
            return null;
        EmployeeNode removedNode = head;
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
        EmployeeNode  current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
