package g;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static void main(String[] args) {

        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"}));
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println(numUniqueEmails(new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"}));
    }

    private static int numUniqueEmails(String[] emails) {

        Set<String> uniqueStrings = new HashSet<>();

        for (String s : emails) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i=0; i<s.length(); i++) {

                char c = s.charAt(i);

                if (c == '.') {
                    continue;
                } else if (c == '+') {
                        while (s.charAt(i) != '@') {
                            i++;
                        }
                        while (i <= s.length()-1) {
                            stringBuilder.append(s.charAt(i));
                            i++;
                        }
                } else if (c == '@'){
                    while (i <= s.length()-1) {
                        stringBuilder.append(s.charAt(i));
                        i++;
                    }
                } else {
                    stringBuilder.append(c);
                }

            }
            uniqueStrings.add(stringBuilder.toString());
        }

        return uniqueStrings.size();
    }

}
