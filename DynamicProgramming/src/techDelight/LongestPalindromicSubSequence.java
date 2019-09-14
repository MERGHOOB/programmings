package techDelight;

public class LongestPalindromicSubSequence {


    public static void main(String[] args) {
        String string = "bb";
        System.out.println(new LongestPalindromicSubSequence().longestPalindrome(string));

    }

    private String longestPalindrome(String text) {

        if (text.isEmpty() || text.length() == 1) {
            return text;
        }


        boolean[][] dp = new boolean[text.length()][text.length()];

        int start = 0;
        int maxLen = 1;
        //Fill for length 1
        for (int i = 0; i < text.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < text.length() - 1; i++) {
            dp[i][i + 1] = text.charAt(i) == text.charAt(i + 1);
            if (dp[i][i + 1]) {
                start = i;
                maxLen = 2;
            }
        }


        //For k =3 to k= n
        for (int k = 3; k <= text.length(); k++) {

            //Fix the start index;
            for (int i = 0; i <= text.length() - k; i++) {

                int endingIndex = i + k - 1;
                dp[i][endingIndex] = text.charAt(endingIndex) == text.charAt(i) &&
                        dp[i + 1][endingIndex - 1];

                if (dp[i][endingIndex]) {
                    maxLen = Integer.max(maxLen, k);
                    start = i;
                }


            }
        }

        return text.substring(start, start + maxLen);
//
    }


}
