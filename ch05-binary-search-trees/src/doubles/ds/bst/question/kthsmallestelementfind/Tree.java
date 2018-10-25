package doubles.ds.bst.question.kthsmallestelementfind;

public interface Tree<T> {

    public Node<T> getKthSmallest(Node<T> node, int k); // k번째 작은 요소 찾기
    public Node<T> getRoot();   // 루트노드 반환
    public void insert(T data); // 삽입
    public T getMinValue();     // 최소값
    public T getMaxValue();     // 최대값
    public void traversal();    // 순회
    public void delete(T data); // 삭제

}
