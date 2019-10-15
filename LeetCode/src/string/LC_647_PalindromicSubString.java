package string;




public class LC_647_PalindromicSubString {


/* DP SOLUTION
    Consider the case: aabaa

    a, aa, 'aa', aba, aabaa

    pall(i, j) = if(st(i) == st(j) && pall(i+1, j+1)
                 false.
                          pall(i+1, j) and moved to pall(i-1, j)

    It means we will require all substring to consider.

    for len, from 1 to n,
        for each i chose j
            store the result in dp



 */


    public static int countSubstrings(String s) {

        int value = 0;
        boolean dp [][] = new boolean[s.length()][s.length()];
        for(int i = 0; i<s.length();i++) {
            dp[i][i] = true;
            value++;
        }
        for(int i = 1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                dp[i-1][i] = true;
                value++;
            }
        }
        for(int len =3; len<=s.length(); len++) {
            for(int i =0; i<s.length()-len+1; i++) {
                int j = i+len-1;

                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                if(dp[i][j]) {
                    value++;
                }
            }
        }
        return value;
    }

    public static void main(String[] args) {
//        System.out.println(countSubstrings("a"));
//        System.out.println(countSubstrings("aa"));
        System.out.println(countSubstrings("aaaaa"));
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings(""));
    }
}
