package dp;

import java.util.Arrays;

/*

 // number of substring of 1 size and number of substring of 2 size which are valid( means numerical value should be less than 27)

        int num = decode(s[1]) + numDecoding(s{1..n}}) + if(decodeValid(s[1..2])) (s[2...n])

        can use DP
 */
public class LC91_DecodeWays {

    public static int numDecodings(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 :1;
        for(int i = 2; i<dp.length;i++) {
            int one = s.charAt(i-1) - '0';
            int two = (s.charAt(i-2) - '0') * 10 + one;
            if(one > 0){
                dp[i] += dp[i-1];
            }
            if(two >= 10 && two < 27) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public static int numDecodings1(String s) {
        if (s.isEmpty() || s.contains("00") || s.startsWith("0")) {
            return 0;
        }
        int n = s.length();
        int dp[] = new int[n + 2];
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') { // when character is 0 andit can not be decoded so no decoding ways here.
                dp[i] = 0;
                continue;
            }
            dp[i] += dp[i + 1];
            if (i + 2 <= s.length()) {
                int x = valid(i, i + 2, s);
                if (x != 0) { //only add when substring is valid.
                    if (i + 2 == s.length()) { // i+2 is out of length of s.
                        dp[i] += 1;  // and substring of size two is valid so atleast one is increased.
                    } else
                        dp[i] += dp[i + 2];//==0? 1 : dp[i+2] ; // otherwise add number of ways at i+2;

                }
                if (dp[i] == 0) { // this case can also handle first if
                    return dp[i];
                }
            }

        }
        return dp[0];
    }


    private static int valid(int index1, int index2, String s) {
        if (index2 > s.length()) {
            return 0;
        }
        String substring = s.substring(index1, index2);
        if(Integer.parseInt(substring) <1){
            return 0;
        }
        if (Integer.parseInt(substring) < 27) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("2122"));
        System.out.println(numDecodings("122"));
        System.out.println(numDecodings("1"));
        System.out.println(numDecodings("102"));
        System.out.println(numDecodings("10"));
        System.out.println(numDecodings("1010"));
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("110"));
        System.out.println(numDecodings("1000"));
    }
}
