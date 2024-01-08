import java.util.Stack;

public class MinStack155P1 {

    private static Stack<Integer> mainStack;
    private static Stack<Integer> minStack;

    public MinStack155P1() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        mainStack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }

    }

    public void pop() {
        if (minStack.peek().equals(mainStack.peek())) {
            minStack.pop();
        }
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack155P1 minStack = new MinStack155P1();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }

}
