package doubles.ds.avltree.implement.generic;

public interface Tree<T> {

    public void insert(T data); // 삽입
    public void traverse();     // 순회
    public void delete(T data); // 삭제

}
