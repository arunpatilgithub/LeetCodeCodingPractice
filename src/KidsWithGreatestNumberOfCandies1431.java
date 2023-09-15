import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithGreatestNumberOfCandies1431 {

    public static void main(String[] args) {

        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3}, 3));
        System.out.println(kidsWithCandies(new int[]{4,2,1,1,2}, 1));
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = Integer.MIN_VALUE;

        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        List<Boolean> output = new ArrayList<>();

        for (int candy : candies) {
            output.add(candy + extraCandies >= max);
        }

        return output;
    }

}
