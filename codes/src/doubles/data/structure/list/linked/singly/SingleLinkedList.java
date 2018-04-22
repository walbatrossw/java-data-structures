package doubles.data.structure.list.linked.singly;

@SuppressWarnings("unchecked")
public class SingleLinkedList<T> {

    private SingleNode<T> head;
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(T newData) {
        head = new SingleNode<>(newData, head);
        size++;
    }

    public void addAfter(T newData, SingleNode<T> preNode) {
        preNode.setNextNode(new SingleNode<>(newData, preNode.getNextNode()));
        size++;
    }

    public void addLast(T newData) {
        add(size, newData);
        size++;
    }

    public void add(int index, T newData) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addFirst(newData);
            return;
        }
        SingleNode<T> node = getNode(index - 1);
        addAfter(newData, node);
    }

    public T removeFirst() {

        if (head == null)
            return null;

        SingleNode<T> removedNode = head;
        head = head.getNextNode();
        size--;

        return removedNode.getData();
    }

    public T removeAfter(SingleNode<T> preNode) {

        // 삭제할 노드
        SingleNode<T> removedNode = preNode.getNextNode();

        // 삭제할 노드가 null 이면
        if (removedNode == null)
            return null;

        // 삭제된 노드의 다음 노드를 다음 노드로 변경
        preNode.setNextNode(removedNode.getNextNode());
        size--;

        // 삭제된 노드의 데이터 반환
        return removedNode.getData();
    }

    public T remove(int index) {
        if (index < 0 || index >= size)
            return null;

        if (index == 0)
            return removeFirst();

        SingleNode<T> preNode = getNode(index - 1);
        return removeAfter(preNode);
    }

    public T remove(T data) {
        SingleNode<T> node = head;
        SingleNode<T> node2 = null;
        while (node != null && !node.getData().equals(data)) {
            node2 = node;
            node = node.getNextNode();
        }
        if (node == null)
            return null;
        if (node2 == null)
            return removeFirst();
        else
            return removeAfter(node2);
    }

    public int indexOf(T data) {
        SingleNode<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.getData().equals(data))
                return i;
            node = node.getNextNode();
        }
        return -1;
    }

    public SingleNode<T> getNode(int index) {
        if (index < 0 || index >= size)
            return null;
        SingleNode<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        SingleNode<T> node = head;
        System.out.println(head);
        System.out.println(node);
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
            System.out.println(node);
        }
        return node.getData();
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }
}
