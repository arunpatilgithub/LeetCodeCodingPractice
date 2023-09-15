public class StringCompression443 {

    public static void main(String[] args) {

        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));

    }

    private static int compress(char[] chars) {

        int l=0;
        int markerPointer=0;
        while (l < chars.length) {

            int r = l;
            while (r < chars.length && chars[r] == chars[l]) {
                r++;
            }

            chars[markerPointer] = chars[l];
            markerPointer++;
            if(r-l > 1) {
                String repeatLength = r-l+"";
                for(char c: repeatLength.toCharArray()) {
                    chars[markerPointer] = c;
                    markerPointer++;
                }
            }
            l=r;

        }

        return markerPointer;

    }

}
