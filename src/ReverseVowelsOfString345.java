import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseVowelsOfString345 {

    public static void main(String[] args) {

        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("aA"));
        System.out.println(reverseVowels(".,"));
    }

    private static String reverseVowels(String s) {

        int l = 0;
        int r = s.length()-1;
        char[] sArray = s.toCharArray();

        int[] vowels = new int[128];
        String vowelString = "aeiouAEIOU";

        for (int i=0; i<vowelString.length(); i++) {
            vowels[vowelString.charAt(i)] = 1;
        }


        //Set<String> vowels = new HashSet<>(Arrays.asList("a","e","i","o","u","A","E","I","O","U"));

        while(l<r){

            while(l<r && vowels[s.charAt(l)] != 1){
                l++;
            }

            while(l<r && vowels[s.charAt(r)] != 1){
                r--;
            }

            char temp = sArray[l];
            sArray[l] = sArray[r];
            sArray[r] = temp;

            l++;
            r--;
        }

        return String.valueOf(sArray);
    }


}

