package doubles.data.structure.stack;

public interface Stack {

    // 스택 공백여부 확인
    boolean isEmpty();

    // 스택 원소 삽입
    void push(char item);

    // 스택 top 원소 출력
    char pop();

    // 스택 top 원소 삭제
    void delete();

    // 스택 top 원소 반환
    char peek();

}
