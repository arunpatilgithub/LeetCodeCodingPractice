import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber202 {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }

    private static boolean isHappy(int n) {

        if (n == 1) {
            return true;
        }

        Set<Integer> visited = new HashSet<>();
        while (!visited.contains(n)) {

            if (n == 1) {
                return true;
            }

            visited.add(n);
            //Calculate sum of squares
            int tempSum = 0;
            int tempNum = n;
            while (tempNum != 0) {
                int digit = tempNum % 10;
                digit = digit * digit;
                tempSum = tempSum + digit;
                tempNum = tempNum / 10;
            }

            n = tempSum;
        }

        return false;
    }


}
