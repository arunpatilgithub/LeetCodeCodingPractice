import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion6 {

    public static void main(String[] args) {

        System.out.println(convert("PAYPALISHIRING",3));
    }

    private static String convert(String s, int numRows) {

        String res = "";

        if (numRows == 1) {
            return s;
        }

        for (int i=0; i<numRows; i++) {
            int incr = (numRows-1) * 2;
            for (int j = i; j<s.length(); j = j+incr) {
                res = res + s.charAt(j);

                if (i >0 && i < numRows-1 && (j + incr - 2*i)<s.length()) {
                    res = res + s.charAt(j + incr - 2*i);
                }

            }
        }

        return res;

    }

}
