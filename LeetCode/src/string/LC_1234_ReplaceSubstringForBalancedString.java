package string;

import java.util.HashMap;
import java.util.Map;

public class LC_1234_ReplaceSubstringForBalancedString {
    public int balancedString(String s) {

        Map<Character, Integer> map= new HashMap<>();
        for(Character ch: s.toCharArray()) {
                if(!map.containsKey(ch)) {
                    map.put(ch, 0);
                }
                map.put(ch, map.get(ch)+1);
        }

        int n = s.length();
        int need = n/4;

        // determines which needed to be replaced.
        boolean changeRequired = false;
        for(char ch: map.keySet()) {
            if(map.get(ch) > need) {
                changeRequired = true;
            }
            map.put(ch, map.get(ch)-need);
        }
        if(!changeRequired) {
            return 0;
        }
        // it means we need a min length substring which contains specific character of freq as represent by freq in map
        // Use sliding window and try to track what more is needed to find smallest window which contains required
        // frequencies of char
        int start = 0;
        int minLen = n; // minimum lenght possible
        for(int end = 0; end<n; end++) {
            map.put(s.charAt(end), map.get(s.charAt(end))-1);// count it in means one less of character need.

            while(fulfilled(map)) {
                // if all count in count array became >=zero
                // update the min len:
                minLen = Integer.min(minLen, end-start+1);

                // move start char to next char and increase it count as it is required in window.
                map.put(s.charAt(start), map.get(s.charAt(start))+1);
                start++;
                if(start >end) {
                    break;
                }
            }

        }
        return minLen;


        // sliding window as min substring required.
        // start with 1 length substring:


    }

    private boolean fulfilled(Map<Character, Integer> count) {
        for(int val: count.values()) {
            if(val > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String st = "WQWRQQQW";
        System.out.println(new LC_1234_ReplaceSubstringForBalancedString().balancedString(st));
    }
}
