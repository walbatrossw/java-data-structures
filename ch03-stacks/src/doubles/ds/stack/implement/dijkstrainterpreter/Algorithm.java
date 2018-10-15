package doubles.ds.stack.implement.dijkstrainterpreter;

import java.util.Stack;

public class Algorithm {

    private Stack<String> operationStack;
    private Stack<Double> valueStack;

    public Algorithm() {
        this.operationStack = new Stack<>();
        this.valueStack = new Stack<>();
    }

    public void interpreterExpression(String expression) {

        String[] expressionArray = expression.split(" ");

        for (String e : expressionArray) {

            if (e.equals("(")) {

            } else if (e.equals("+")) {
                this.operationStack.push(e);
            } else if (e.equals("*")) {
                this.operationStack.push(e);
            } else if (e.equals(")")) {
                String operation = this.operationStack.pop();
                if (operation.equals("+")) {
                    this.valueStack.push(this.valueStack.pop() + this.valueStack.pop());
                } else if (operation.equals("*")) {
                    this.valueStack.push(this.valueStack.pop() * this.valueStack.pop());
                }
            } else {
                this.valueStack.push(Double.parseDouble(e));
            }
        }

    }

    public void result() {
        System.out.println(this.valueStack.pop());
    }
}
