package techDelight;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    /*
    consider DP:
  https://leetcode.com/problems/word-break/
     */

    public boolean wordBreak(String s, List<String> wordDict) {

        // return wordBreak(s, wordDict, 0); //

        return breakWordDP(s, wordDict);
    }

    public boolean breakWordDP(String word, List<String> dict) {
        boolean []dp = new boolean[word.length()+1];

        dp[0] =  true;

        for(int len =1 ; len <= word.length(); len++) {

            for(int i = 0; i< len; i++) {

                String str = word.substring(i, len);
                if(dp[i] && dict.contains(str)) {
                    dp[len] = true;
                    break;
                }
            }

        }
        return dp[word.length()];


    }

    public static void main(String[] args) {

        List<String> dict = Arrays.asList("aaaa","aa");

        String string = "aaaaaaa";

        System.out.println(new WordBreak().wordBreak(string, dict));

    }

}
