package others;

public class PalindromeChecks {

    public static void main(String[] args) {

        //final int[] inputsOK = { 1, 2, 3, 2, 1 };

        //System.out.println(isPalindromeIterativeCompact(new int[]{ 1, 2, 3, 2, 1 }));
        System.out.println(isPalindromeIterativeCompact(new int[]{ 1, 2, 3, 2, 4 }));

    }

    static boolean isPalindromeIterativeCompact(final int[] values)
    {
        int left = 0;
        int right = values.length - 1;

        while (left < right && values[left] == values[right])
        {
            left++;
            right--;
        }
        // left >= right || values[left] != values[right]
        return left >= right;
    }

}
