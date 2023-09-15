import java.util.Arrays;

public class Candy135 {

    public static void main(String[] args) {

        System.out.println(candy(new int[]{1,0,2}));
        System.out.println(candy(new int[]{1,2,2}));
    }

    private static int candy(int[] ratings) {

        final int N = ratings.length;;

        int[] leftToRightTraverse = new int[N];
        Arrays.fill(leftToRightTraverse, 1);

        for (int i=1; i<N; i++) {
            if (ratings[i]>ratings[i-1]) {
                leftToRightTraverse[i] = leftToRightTraverse[i-1] + 1;
            }
        }


        int[] rightToLeftTraverse = new int[N];
        Arrays.fill(rightToLeftTraverse,1);

        for (int j = N-2; j>=0; j--) {
            if (ratings[j]>ratings[j+1]) {
                rightToLeftTraverse[j] = rightToLeftTraverse[j+1] + 1;
            }
        }

        int candyCount = 0;

        for (int k =0; k<N; k++) {

            candyCount = candyCount + Math.max(leftToRightTraverse[k], rightToLeftTraverse[k]);

        }

        return candyCount;

    }

}
