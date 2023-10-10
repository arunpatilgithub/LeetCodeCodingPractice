import java.util.Stack;

public class MinStack155 {

    public static void main(String[] args) {

    }

    static class MinStack {

        Stack<Node> stack;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int val) {

            if (stack.empty()) {
                stack.push(new Node(val, val));
            } else {
                stack.push(new Node(val, Math.min(val, stack.peek().min)));
            }

        }

        public void pop() {

            if (!stack.isEmpty()) {
                stack.pop();
            }

        }

        public int top() {
            return stack.peek().getVal();
        }

        public int getMin() {
            return stack.peek().min;
        }
    }

    static class Node {

        int val;
        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

}
