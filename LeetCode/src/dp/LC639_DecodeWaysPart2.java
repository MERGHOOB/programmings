package dp;
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

Also, since the answer may be very large, you should return the output mod 109 + 7.
 */


public class LC639_DecodeWaysPart2 {

    private static final long MOD = 1000000007;


    private long add(long one, long two) {
        return ((one % MOD + two % MOD) % MOD);
    }


    public int numDecodings(String s) {
        //'*', which can be treated as one of the numbers from 1 to 9.
        // maximum value to decode as char is 26
        // for two digit: 10 to 26


        long[] dp = new long[s.length() + 1]; // one xtra as one bit off error:
        dp[0] = 1;
        dp[1] = waysWithOneChar(0, s);
        for (int i = 1; i < s.length(); i++) { //off-by-one error, notice s.charAt(i)'s result is stored in dp[i + 1]


            long one = waysWithOneChar(i, s) * dp[i]; // start from 0 as i is 1 initally;
            long two = waysWithtwoChar(i - 1, i, s) * dp[i - 1];

            dp[i + 1] = add(one, two); // result is for i is stored at  i+1;
        }
        return (int) dp[s.length()]; // return last

    }

    private int waysWithtwoChar(int first, int second, String s) {
        char a = s.charAt(first);
        char b = s.charAt(second);

        if (a == '*' && b == '*') { // "**" neither is digit
            return 15;
        } else if (a == '*') {      // "*D" snd is a digit
            return (b > '6') ? 1 : 2;
        } else if (b == '*') {      // "D*" fst is a digit
            return (a == '1') ? 9 : (a == '2') ? 6 : 0;
        } else {                    // "DD" both r digits
            int val = Integer.valueOf("" + a + b);
            return (10 <= val && val <= 26) ? 1 : 0;
        }
    }

    private int waysWithOneChar(int i, String s) {
        char a = s.charAt(i);
        if (a == '*') {
            return 9;
        } else if (a != '0') {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(new LC639_DecodeWaysPart2().numDecodings("*"));
//        System.out.println(new LC639_DecodeWaysPart2().numDecodings("1*"));
        System.out.println(new LC639_DecodeWaysPart2().numDecodings("*2"));
        System.out.println(new LC639_DecodeWaysPart2().numDecodings("1*"));
        System.out.println(new LC639_DecodeWaysPart2().numDecodings("**"));

    }


}
