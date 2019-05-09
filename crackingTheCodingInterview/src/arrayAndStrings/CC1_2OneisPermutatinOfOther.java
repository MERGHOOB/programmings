package arrayAndStrings;

import java.util.Arrays;

/**
 * 1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the
 * other.
 */
public class CC1_2OneisPermutatinOfOther {

    // Ask if whitespace is significant? if yes, it means 'ab   ' is not a permutation of 'ba', we assume YES
    //Ask if case-sensitive? means "YES", is not a permutation of "sey", We assume NO.

    public boolean isPermutation(String one, String two) {

        if (one.length() != two.length()) {
            return false;
        }


        return sort(one).equals(sort(two));


    }

    private String sort(String cand) {
        char[] content = cand.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    // Other solution is to having an array regarding the count
    // Assuming only ASCII character has been used.


    public boolean isPermutationWithHelpOfCountingCharacter(String one, String two) {

        int latters[] = new int[128]; //by default values comes a zero in each cell

        //traverse one
        char[] oneArray = one.toCharArray();
        for (char c : oneArray) {
            latters[c]++;
        }

        char[] twoArray = two.toCharArray();
        for (char c : twoArray) {
            latters[c]--;
            if (latters[c] == 0) {
                return false;
            }
        }

        return true;
    }


}
