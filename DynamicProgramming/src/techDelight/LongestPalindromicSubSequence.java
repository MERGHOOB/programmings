package techDelight;

public class LongestPalindromicSubSequence {


    public static void main(String[] args) {
        String string = "bbcc";
        System.out.println(new LongestPalindromicSubSequence().longestPalindrome(string));

    }

    //NOT MUCH FAST
//    private String longestPalindrome(String text) {
//
//        if (text.isEmpty() || text.length() == 1) {
//            return text;
//        }
//
//
//        boolean[][] dp = new boolean[text.length()][text.length()];
//
//        int start = 0;
//        int maxLen = 1;
//        //Fill for length 1
//        for (int i = 0; i < text.length(); i++) {
//            dp[i][i] = true;
//        }
//
//        for (int i = 0; i < text.length() - 1; i++) {
//            dp[i][i + 1] = text.charAt(i) == text.charAt(i + 1);
//            if (dp[i][i + 1]) {
//                start = i;
//                maxLen = 2;
//            }
//        }
//
//
//        //For k =3 to k= n
//        for (int k = 3; k <= text.length(); k++) {
//
//            //Fix the start index;
//            for (int i = 0; i <= text.length() - k; i++) {
//
//                int endingIndex = i + k - 1;
//                dp[i][endingIndex] = text.charAt(endingIndex) == text.charAt(i) &&
//                        dp[i + 1][endingIndex - 1];
//
//                if (dp[i][endingIndex]) {
//                    maxLen = Integer.max(maxLen, k);
//                    start = i;
//                }
//
//
//            }
//        }
//
//        return text.substring(start, start + maxLen);
////
//    }

    //
    private String longestPalindrome(String text) {
        if(text.isEmpty() || text.length()==1) {
            return text;
        }
        int start = 0;
        int end = 0;

        for(int i = 0; i<text.length(); i++) {
            int len1  = expandAroundCenter(text, i, i); // with odd length;
            int len2 = expandAroundCenter(text, i, i+1); //with even;

            int len = Integer.max(len1, len2);
            if(len > end-start) {
                start = i - (len-1)/2;
                end = i+(len/2);
            }
            
        }
        return text.substring(start, end+1);
    }

    private int expandAroundCenter(String text, int left, int right) {
        int start = left, end = right;

        while(start>=0 && end <text.length() && text.charAt(start) == text.charAt(end)) {
            start--;
            end++;
        }

        return end - start-1;
    }
}
