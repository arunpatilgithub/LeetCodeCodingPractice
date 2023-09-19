import java.util.Stack;

public class DecodeString394 {

    public static void main(String[] args) {

        System.out.println(decodeString("32[a]2[bc]"));
        //System.out.println(decodeString("3[a2[bc]]"));

    }

    private static String decodeString(String s) {

        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int multiplier = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                multiplier = multiplier * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(current);
                stack.push(new StringBuilder().append(multiplier));
                current = new StringBuilder();
                multiplier = 0;
            } else if (c == ']') {
                StringBuilder temp = current;
                current = stack.pop(); // pop the multiplier
                int mul = Integer.parseInt(current.toString());
                current = stack.pop(); // pop the previous string
                for (int i = 0; i < mul; i++) {
                    current.append(temp);
                }
            } else {
                current.append(c);
            }
        }

        return current.toString();

    }

    private static String decodeString2(String s) {


        Stack<String> stack = new Stack<>();

        for(char c : s.toCharArray()) {

            if (c != ']') {
                stack.push(String.valueOf(c));
            } else {
                StringBuilder temp = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    temp = temp.insert(0,stack.pop());
                }
                stack.pop();
                StringBuilder multiplier = new StringBuilder();

                while (!stack.empty() && Character.isDigit(stack.peek().charAt(0))) {
                    multiplier = multiplier.insert(0,stack.pop());
                }
                int mul = Integer.parseInt(multiplier.toString());

                StringBuilder stringToPush = new StringBuilder();
                for (int i=0; i<mul; i++) {
                    stringToPush = stringToPush.append(temp);
                }

                stack.push(stringToPush.toString());

            }

        }

        StringBuilder output = new StringBuilder();

        while (!stack.empty()) {
            output = output.insert(0,stack.pop());
        }

        return output.toString();

    }


}
