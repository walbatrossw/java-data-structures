package doubles.ds.stack.question.maxitemstack;

import doubles.ds.stack.implement.array.Stack;

public class MaxItemStack {

    private Stack<Integer> mainStack;   // 원본 Stack
    private Stack<Integer> maxStack;    // 최대값을 구하기 위한 Stack

    public MaxItemStack() {
        this.mainStack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    // 삽입 연산
    public void push(int item) {

        mainStack.push(item); // 원본 Stack에 삽입

        // 첫번째 삽입일 경우  mainStack과 같이 maxStack에 삽입
        if (mainStack.size() == 1) {
            maxStack.push(item);
            return;
        }

        // 새롭게 삽입할 항목이 maxStack의 최대값보다 크면
        if (item > maxStack.peek()) {
            maxStack.push(item);
        // 크지 않다면 기존의 최대값을 삽입
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    // 삭제 연산 : maxStack, mainStack 둘다 항목 제거
    public int pop() {
        maxStack.pop();
        return mainStack.pop();
    }

    // 최대값 반환
    public int getMaxItem() {
        return maxStack.peek();
    }

}
