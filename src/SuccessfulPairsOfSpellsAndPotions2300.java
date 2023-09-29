import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions2300 {

    public static void main(String[] args) {

        Arrays.stream(successfulPairs(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 7)).forEach(System.out::println);
        Arrays.stream(successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 16)).forEach(System.out::println);

    }

    private static int[] successfulPairs(int[] spells, int[] potions, long success) {

        int[] output = new int[spells.length];

        Arrays.sort(potions);

        int iterator = 0;
        for (int s : spells) {
            int minIndexPos = -1;
            int l= 0;
            int r = potions.length-1;
            while (l<=r) {

                int mid = l + (r-l) / 2;

                if ((long)s * potions[mid] >= success) {
                    minIndexPos = mid;
                    r = mid -1 ;
                } else {
                    l = mid + 1;
                }

            }
            output[iterator] = minIndexPos != -1 ? potions.length - minIndexPos : 0;
            iterator++;
        }


        return output;
    }

}
