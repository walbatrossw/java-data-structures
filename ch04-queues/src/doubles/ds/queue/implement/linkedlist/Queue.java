package doubles.ds.queue.implement.linkedlist;

public class Queue<T extends Comparable<T>> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;

    // Queue 공백 확인
    public boolean isEmpty() {
        return this.firstNode == null;
    }

    // Queue 사이즈
    public int size() {
        return this.count;
    }

    // O(1) 시간 복잡도
    public void enqueue(T newData) {
        this.count++;
        Node<T> oldLastNode = this.lastNode;
        this.lastNode = new Node<>(newData);
        this.lastNode.setNextNode(null);

        // Queue가 비어있으면
        if (isEmpty()) {
            this.firstNode = this.lastNode;
        // Queue가 비어있지 않으면
        } else {
            oldLastNode.setNextNode(this.lastNode);
        }
    }

    // O(1) 시간 복잡도
    public T dequeue() {
        this.count--;

        T dataToDequeue = this.firstNode.getData();
        this.firstNode = this.firstNode.getNextNode();

        if (isEmpty()) {
            this.lastNode = null;
        }
        return dataToDequeue;
    }
}
