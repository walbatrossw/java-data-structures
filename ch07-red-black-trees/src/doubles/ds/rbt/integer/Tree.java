package doubles.ds.rbt.integer;

public interface Tree {

    public void insert(int data);   // 삽입
    public void remove(int value);  // 삭제
    public void traverse();         // 순회
    public Node getMax();           // 최대값 반환
    public Node getMin();           // 최소값 반환

}
