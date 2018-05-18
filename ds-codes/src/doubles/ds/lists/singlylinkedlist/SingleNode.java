package doubles.ds.lists.singlylinkedlist;

public class SingleNode<T> {

    private T data;                 // 데이터
    private SingleNode<T> next;     // 다음 노드


    public SingleNode(T data) {
        this.data = data;
        this.next = null;
    }

    public SingleNode(T data, SingleNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SingleNode<T> getNext() {
        return next;
    }

    public void setNext(SingleNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
