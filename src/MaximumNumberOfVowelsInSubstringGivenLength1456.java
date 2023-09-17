public class MaximumNumberOfVowelsInSubstringGivenLength1456 {

    public static void main(String[] args) {

        System.out.println(maxVowels("abciiidef",3));
        System.out.println(maxVowels("aeiou",2));
        System.out.println(maxVowels("leetcode",3));
    }

    private static int maxVowels(String s, int k) {

        String vowels = "aeiou";
        int[] vowelsArray = new int[128];

        // Set vowels in the vowelsArray
        for (char c : vowels.toCharArray()) {
            vowelsArray[c] = 1;
        }

        int vowelCount = 0;

        // Count vowels in the initial window
        for (int i = 0; i < k; i++) {
            if (vowelsArray[s.charAt(i)] == 1) {
                vowelCount++;
            }
        }
        int maxVowelCount = vowelCount;

        int l = 0;
        int r = k;

        while (r < s.length()) {

            if (vowelsArray[s.charAt(l)] == 1) {
                vowelCount--;
            }

            if (vowelsArray[s.charAt(r)] == 1) {
                vowelCount++;
            }

            maxVowelCount = Math.max(maxVowelCount, vowelCount);
            l++;
            r++;
        }

        return maxVowelCount;
    }


}
