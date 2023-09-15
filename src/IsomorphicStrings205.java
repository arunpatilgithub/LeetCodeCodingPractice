import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205 {

    public static void main(String[] args) {

        System.out.println(isIsomorphic("badc","baba"));
        System.out.println(isIsomorphic("egg","add"));
        System.out.println(isIsomorphic("foo","bar"));
        System.out.println(isIsomorphic("paper","title"));
    }

    private static boolean isIsomorphic(String s, String t) {

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b))
                    continue;
                else
                    return false;
            }else{
                if(!map.containsValue(b))
                    map.put(a,b);
                else return false;

            }
        }
        return true;
    }

}
