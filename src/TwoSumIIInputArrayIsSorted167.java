public class TwoSumIIInputArrayIsSorted167 {

    public static void main(String[] args) {

        int[] res = twoSum(new int[]{-1,0},-1);

        System.out.println(res[0] + "," + res[1]);
    }

    private static int[] twoSum(int[] numbers, int target) {

        int l = 0;
        int r = numbers.length-1;
        while (l<r) {
            int sum = numbers[l] + numbers[r];

            if (sum == target) {
                return new int[]{l+1,r+1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }

        return new int[2];
    }

}
