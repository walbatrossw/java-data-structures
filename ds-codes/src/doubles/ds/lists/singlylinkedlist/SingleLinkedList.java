package doubles.ds.lists.singlylinkedlist;

public class SingleLinkedList<T> {

    private SingleNode<T> head;    // 단순 연결리스트의 첫노드
    private int size;           // 단순 연결리스트의 사이즈

    // 생성자
    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }


    public SingleNode getNode(int index) {
        SingleNode current = head;
        for (int i = 0; i <= index; i++) {
            current = current.getNext();
        }
        return current;
    }

    // 연결리스트 첫 노드 앞에 노드 추가
    public void addFirst(T newData) {
        head = new SingleNode(newData, head);
        size++;
    }

    // 연결리스트 특정 노드 뒤에 노드 추가
    public void addAfter(T newData, SingleNode prev) {
        prev.setNext(new SingleNode(newData, prev.getNext()));
        size++;
    }

    // 연결리스트 마지막 노드 추가
    public void addLast(T newData) {

        if (head == null) {
            addFirst(newData);
            return;
        }

        SingleNode newNode = new SingleNode(newData);
        SingleNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);

    }

    // 연결리스트 출력
    public void printLinkedList() {

        if (head == null) {
            return;
        }

        SingleNode current = head;

        System.out.print("head -> ");

        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
