package doubles.ds.doublylinkedlist;

public class DoubleList<E> {

    private DoubleNode<E> head;
    private DoubleNode<E> tail;
    private int size;

    public DoubleList() {
        this.head = new DoubleNode<>(null);
        this.tail = new DoubleNode<>(null);
        head.setNextNode(tail);
        this.size = 0;
    }

    public DoubleNode<E> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        DoubleNode<E> node = head;
        if (index < (size / 2)) {
            for (int i = 0; i <= index; i++) {
                node = node.getNextNode();
            }
        } else {
            for (int i = size; i > index; i--) {
                node = node.getPreNode();
            }
        }
        return node;
    }

    public void addFirst(E newItem) {
        DoubleNode<E> newNode = new DoubleNode<>(newItem);
        newNode.setNextNode(head.getNextNode());
        if (head.getNextNode() != null) {
            head.getNextNode().setPreNode(newNode);
        } else {
            head.setPreNode(newNode);
        }
        head.setNextNode(newNode);
        size++;
    }

    // 리스트 데이터 출력
    public void printList() {
        DoubleNode<E> p = head;
        for (int i = 0; i < size; i++) {
            System.out.print(p + "");
            p = p.getNextNode();
        }
        System.out.println();
    }

}
