package doubles.ds.bst.question.comparetrees;

public interface Tree<T> {

    public Node<T> getRoot();   // 루트노드 반환
    public void insert(T data); // 삽입
    public T getMinValue();     // 최소값
    public T getMaxValue();     // 최대값
    public void traversal();    // 순회
    public void delete(T data); // 삭제

}
