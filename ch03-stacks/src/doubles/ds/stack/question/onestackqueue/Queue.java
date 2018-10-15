package doubles.ds.stack.question.onestackqueue;

import java.util.Stack;

public class Queue {

    // Stack 선언
    private Stack<Integer> stack;

    // 생성자
    public Queue() {
        this.stack = new Stack<>();
    }

    // Queue 삽입연산
    public void enqueue(int item) {
        this.stack.push(item);
    }

    // Queue 삭제 연산 : Stack 하나만을 사용하여 구현, call stack을 통한 재귀호출
    public int dequeue() {
        // Stack 사이즈가 1이면 삭제 연산 수행 : 마지막 항목이면 삭제처리
        if (stack.size() == 1) {
            return stack.pop();
        }
        // 미자막 항목을 찾을 때까지 pop 연산을 수행
        int item = stack.pop();
        // 재귀 호출 수행
        int lastDequeueItem = dequeue();
        // 꺼낸 항목을 다시 삽입
        enqueue(item);
        // 마지막 항목 반환
        return lastDequeueItem;
    }

}
