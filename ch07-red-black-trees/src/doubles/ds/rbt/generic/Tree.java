package doubles.ds.rbt.generic;

public interface Tree<T> {

    public void insert(T data);     // 삽입
    public void remove(T value);    // 삭제
    public void traverse();         // 순회
    public Node<T> getMax();        // 최대값 반환
    public Node<T> getMin();        // 최소값 반환

}
