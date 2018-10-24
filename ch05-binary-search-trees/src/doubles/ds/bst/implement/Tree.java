package doubles.ds.bst.implement;

public interface Tree<T> {

    public void insert(T data); // 삽입
    public T getMinValue();     // 최소값
    public T getMaxValue();     // 최대값
    public void traversal();    // 순회
    public void delete(T data); // 삭제

}
