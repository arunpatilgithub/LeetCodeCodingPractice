import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons452 {

    public static void main(String[] args) {

        System.out.println(findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        System.out.println(findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
    }

    private static int findMinArrowShots(int[][] points) {

        int arrows = 1;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrowPosition = points[0][1];

        for (int p=1; p<points.length; p++) {

            if (points[p][0] > arrowPosition) {
                arrows++;
                arrowPosition = points[p][1];
            }

        }

        return arrows;

    }

}
