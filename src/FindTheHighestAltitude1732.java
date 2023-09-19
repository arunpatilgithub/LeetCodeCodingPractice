public class FindTheHighestAltitude1732 {

    public static void main(String[] args) {

        System.out.println(largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }

    private static int largestAltitude(int[] gain) {

        int maxAltitude = 0;
        int runningAltitude = 0;

        for (int i=0; i<gain.length; i++) {
            runningAltitude = runningAltitude + gain[i];
            maxAltitude = Math.max(maxAltitude, runningAltitude);
        }

        return maxAltitude;

    }

}
