import java.util.Stack;

public class BasicCalculator224 {

    public static void main(String[] args) {

        //System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("1 + 1"));

    }

    private static int calculate(String s) {

        int sign = 1;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {

            //Number
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder num = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num.append(s.charAt(i));
                    i++;
                }
                sum = sum + Integer.parseInt(num.toString()) * sign;
                i--;
            } else if (s.charAt(i) == '+') { // +
                sign = 1;
            } else if (s.charAt(i) == '-') { // -
                sign = -1;
            } else if (s.charAt(i) == '(') { // (
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') { // )
                sum = sum * stack.pop();
                sum = sum + stack.pop();
            }

        }

        return sum;

    }

}
