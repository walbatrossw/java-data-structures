package doubles.ds.linkedlist.implement;

// 리스트 인터페이스
public interface List<T> {

    public void insert(T data); // 삽입 연산
    public void remove(T data); // 삭제 연산
    public void traverseList(); // 리스트 전체 탐색
    public int size();          // 리스트 사이즈 반환

}
