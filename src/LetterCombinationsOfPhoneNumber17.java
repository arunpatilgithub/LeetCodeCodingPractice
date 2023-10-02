import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber17 {

    public static void main(String[] args) {

        letterCombinations("23").forEach(System.out::println);

    }

    private static List<String> letterCombinations(String digits) {

        List<String> output = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return output;
        }

        HashMap<Character, String> charMaps = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrackRecursion(digits, output,charMaps,0,"");

        return output;

    }

    private static void backtrackRecursion(String digits,
                                           List<String> output,
                                           HashMap<Character, String> charMaps,
                                           int index,
                                           String currentCombo) {


        if (index >= digits.length()) {
            output.add(currentCombo);
            return;
        }

        String letters = charMaps.get(digits.charAt(index));

        for (char c : letters.toCharArray()) {
            backtrackRecursion(digits, output, charMaps, index+1, currentCombo+c);
        }

    }

}
