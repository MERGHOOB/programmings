package arrayAndStrings;


/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rea rrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat". "atco cta". etc.)
 */
public class CC1_4_PallindromePermutation {


    // it is not case sensitive, first of all
    //space to be considered but it seems it does not matter

    public boolean isPallindromePermutation(String cand) {
        //For a pallindrome, character count must be even except middle char and space
        //considering that extended ascii is present, we


        int latters[] = new int[256];

        char[] candArray = cand.toLowerCase().toCharArray();
        for(char c: candArray) {
            if(c!=' ') {
                latters[c]++;
            }
        }

        int found  = 0;
        for(int i = 0; i<256;i++) {
            if(latters[i] == 0 || latters[i]%2 ==0 ) {
                continue;
            }
            found++;
            if(found == 2) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CC1_4_PallindromePermutation().isPallindromePermutation("Tabct Coa"));
    }





}
