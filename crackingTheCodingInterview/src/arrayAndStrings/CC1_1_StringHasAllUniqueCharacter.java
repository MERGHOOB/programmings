package arrayAndStrings;

import java.util.*;

/**
 * 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 */


public class CC1_1_StringHasAllUniqueCharacter {

    public boolean isHasUniqueCharacter(String cand) {

//
  //      return isHasUniqueCharacterWithHelpOfDataStructure(cand); // simple fix



        return isHasUniqueCharacterWithoutHelpOfDataStructure(cand);
        // Without addition dataStructure
        // sort the string, char array and then traverse and found if something is same as previous


    }

    private boolean isHasUniqueCharacterWithoutHelpOfDataStructure(String cand) {

        if(cand.length() <2) {
            return true;
        }
        char[] chars = cand.toCharArray();
        List<Character> charList = new ArrayList<>();

        for (char c: chars) {
            charList.add(c);
        }

        Collections.sort(charList);

        int previous = 0;
        for(int i =1; i<charList.size(); i++) {
            if(charList.get(previous) == charList.get(i)) {
                return false;
            }
            previous++;
        }


        return true;

    }

    /**
     * This method takes help of additional DataStructure(a hashset) to check whether character uniqueness present in string or not
     *
     */
    private boolean isHasUniqueCharacterWithHelpOfDataStructure(String cand) {
        Set<Character> set = new HashSet<>();

        for(int i = 0; i<cand.length(); i++) {
            if (set.contains(cand.charAt(i))) {
                return false;
            }

            set.add(cand.charAt(i));
        }

        return true;
    }


}
