package doubles.ds.lists.siglylinkedlist;

import doubles.ds.Employee;

public class EmployeeSingleLinkedList {

    private EmployeeSingleNode head; // 연결리스트의 첫노드
    private int size; // 연결리스트의 사이즈

    // 연결리스트의 첫노드 삽입
    public void addToFront(Employee employee) {
        EmployeeSingleNode node = new EmployeeSingleNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    // 연결리스트 첫노드 삭제
    public EmployeeSingleNode removeFormFront() {
        if (isEmpty())
            return null;
        EmployeeSingleNode removedNode = head;
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
        EmployeeSingleNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
