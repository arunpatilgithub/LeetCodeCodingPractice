import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {

    public static void main(String[] args) {

        System.out.println(wordPattern("abba","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog cat cat fish"));
        System.out.println(wordPattern("aaaa","dog cat cat dog"));
    }

    private static boolean wordPattern(String pattern, String s) {

        String[] sArray = s.split(" ");

        if (pattern.length() != sArray.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();

        for(int i = 0 ; i< pattern.length(); i++){

            char cPattern = pattern.charAt(i);
            String ss = sArray[i];

            if(map.containsKey(cPattern)){
                if(map.get(cPattern).equals(ss))
                    continue;
                else
                    return false;
            }else{
                if(!map.containsValue(ss))
                    map.put(cPattern,ss);
                else return false;

            }
        }
        return true;
    }

}
