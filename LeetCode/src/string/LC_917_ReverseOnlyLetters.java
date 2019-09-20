package string;

/*
917. Reverse Only Letters
Easy

297

29

Favorite

Share
Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.



Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"


Note:

S.length <= 100
33 <= S[i].ASCIIcode <= 122
S doesn't contain \ or "
 */
public class LC_917_ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {


        char [] chars = S.toCharArray();


        int i = 0;
        int j = chars.length-1;

        while(i<j) {


            if(!isLetter(chars[i])) {
                i++;
                continue;
            }
            if(!isLetter(chars[j])) {
                j--;
                continue;
            }

            if(isLetter(chars[i]) && isLetter(chars[j])) {
                doSwap(i, j, chars);
                i++;
                j--;
            }


        }

        return new String(chars);

    }

    private boolean isLetter(char val) {
        return (val >= 'a' && val <= 'z') ||
                (val >= 'A' && val <='Z' );
    }

    private void doSwap(int i, int j, char[] chars) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
