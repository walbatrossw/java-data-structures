package doubles.ds.stack.question.twostackqueue;

import java.util.Stack;

public class Queue {

    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    // 생성자
    public Queue() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }

    // 삽입 연산
    public void enqueue(int item) {
        this.enqueueStack.push(item);
    }

    // 삭제 연산
    public int dequeue() {
        // queue 구현을 위한 stack들이 둘다 비어있으면 예외 발생
        if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
            throw new RuntimeException("Stacks are empty...");
        }

        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }

}
