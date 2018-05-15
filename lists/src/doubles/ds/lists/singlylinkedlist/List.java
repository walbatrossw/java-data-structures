package doubles.ds.lists.singlylinkedlist;

public interface List<T> {

    public void insert(T data); // 입력
    public void remove(T data); // 삭제
    public void traverseList(); // 탐색
    public int size();  // 사이즈

}
