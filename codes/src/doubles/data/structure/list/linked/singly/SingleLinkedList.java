package doubles.data.structure.list.linked.singly;

@SuppressWarnings("unchecked")
public class SingleLinkedList<T> {

    private SingleNode<T> head; // 연결리스트 첫 노드
    private int size;           // 연결리스트 사이즈

    // 생성자
    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // 연결리스트 삽입 : 첫 노드 추가
    public void addFirst(T newData) {
        head = new SingleNode<>(newData, head);
        size++;
    }

    // 연결리스트 삽입 : 특정 노드 뒤에 추가
    private void addAfter(T newData, SingleNode<T> preNode) {
        preNode.setNextNode(new SingleNode<>(newData, preNode.getNextNode()));
        size++;
    }

    // 연결리스트 삽입 : 특정 인덱스에 노드 추가
    public void add(int index, T newData) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addFirst(newData);
            return;
        }
        SingleNode<T> preNode = getNode(index - 1);
        addAfter(newData, preNode);
    }

    // 연결리스트 삽입 : 마지막 노드 추가
    public void addLast(T newData) {
        add(size, newData);
    }

    // 연결리스트 삭제 : 첫노드에 제거
    public T removeFirst() {
        if (head == null)
            return null;

        SingleNode<T> removedNode = head;
        head = head.getNextNode();
        size--;

        return removedNode.getData();
    }

    // 연결리스트 삭제 : 특정 노드 뒤에 노드 제거
    private T removeAfter(SingleNode<T> preNode) {
        SingleNode<T> removedNode = preNode.getNextNode();
        if (removedNode == null)
            return null;

        preNode.setNextNode(removedNode.getNextNode());
        size--;

        return removedNode.getData();
    }

    // 연결리스트 삭제 : 마지막 노드 제거
    public T removeLast() {
        return remove(size-1);
    }

    // 연결리스트 삭제 : 특정 인덱스의 노드 제거
    public T remove(int index) {
        checkValidIndex(index);
        if (index == 0)
            return removeFirst();
        SingleNode<T> preNode = getNode(index - 1);
        return removeAfter(preNode);
    }

    // 연결리스트 삭제 : 특정 데이터의 노드 제거
    public T remove(T data) {
        int index = indexOf(data);
        if (index == -1)
            return null;
        return remove(index);
    }

    // 특정 데이터의 인덱스 반환
    public int indexOf(T data) {
        SingleNode<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.getData().equals(data))
                return i;
            node = node.getNextNode();
        }
        return -1;
    }

    // 특정 인덱스의 노드 반환
    private SingleNode<T> getNode(int index) {
        checkValidIndex(index);
        SingleNode<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node;
    }

    // 특정 인덱스의 노드 데이터 반환
    public T get(int index) {
        checkValidIndex(index);
        SingleNode<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node.getData();
    }

    private void checkValidIndex(int index) {
        if (isValidIndex(index))
            throw new IndexOutOfBoundsException("index = " + index + ", size = " + size);
    }

    private boolean isValidIndex(int index) {
        return index < 0 || index >= size;
    }

    // 연결리스트의 사이즈 반환
    public int getSize() {
        return size;
    }

    // 연결리스트의 노드 데이터 목록 반환
    public void printLinkedList(SingleLinkedList<T> list) {
        for (int i = 0; i < list.getSize(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }
}
