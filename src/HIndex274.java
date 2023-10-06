import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HIndex274 {

    public static void main(String[] args) {

        System.out.println(hIndex(new int[]{3,0,6,1,5}));
        //System.out.println(hIndex(new int[]{1,3,1}));
        //System.out.println(hIndex(new int[]{100}));
    }

    private static int hIndex(int[] citations) {

        //0 1 3 5 6

        Arrays.sort(citations);

        int n = citations.length;
        int i;

        for(i = 1; i <= n; ++i) {
            if(citations[n-i] < i) {
                break;
            }
        }

        return i-1;

    }

}