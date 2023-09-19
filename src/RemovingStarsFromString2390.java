import java.util.Stack;

public class RemovingStarsFromString2390 {

    public static void main(String[] args) {

        System.out.println(removeStars("leet**cod*e"));
        System.out.println(removeStars("erase*****"));

    }

    private static String removeStars(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c == '*' && stack.peek() != '*') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        if (stack.empty()) {
            return "";
        }

        char[] output = new char[stack.size()];
        for (int i= output.length-1; i>=0; i-- ) {
            output[i] = stack.pop();
        }


        return String.valueOf(output);
    }

}
