package techDelight;

import java.util.HashMap;
import java.util.Map;

public class ShortestCommonSuperSequence {

    public static void main(String[] args) {
        String first = "ABCBDAB";
        String second = "BDCABA";

        System.out.println(new ShortestCommonSuperSequence().scsLength(first, second));
        new ShortestCommonSuperSequence().printShortestSuperSequence(first, second);

    }

    private int scsLength(String first, String second) {
        Map<String, Integer> lookup = new HashMap<>();
//        return scsLength(first, first.length(), second, second.length(), lookup);
        return scsLengthBottomUp(first, first.length(), second, second.length());
    }

    private int scsLength(String first, int m, String second, int n, Map<String, Integer> lookup) {
        if (m == 0 || n == 0) {
            return n + m;
        }

        String key = m + "|" + n;

        if (lookup.get(key) == null) {
            if (first.charAt(m - 1) == second.charAt(n - 1)) {
                lookup.put(key, scsLength(first, m - 1, second, n - 1, lookup) + 1);
            } else {
                lookup.put(key, Integer.min(scsLength(first, m - 1, second, n, lookup) + 1,
                        scsLength(first, m, second, n - 1, lookup) + 1));
            }
        }
        return lookup.get(key);
    }

    //With bottom-up
    private int scsLengthBottomUp(String first, int m, String second, int n) {


        int[][] lookup = fillLookUpTable(first, second);
        return lookup[m][n];
    }

    private int[][] fillLookUpTable(String first, String second) {
        int m = first.length();
        int n = second.length();
        int [][] lookup = new int[m+1][n+1];
        for (int i = 0; i<=m; i++) {

            for(int j = 0; j<=n; j++) {
                if(i == 0 || j==0) {
                    lookup[i][j] = i+j;
                    continue;
                }

                if(first.charAt(i-1) == second.charAt(j-1)) {
                    lookup[i][j] = lookup[i-1][j-1]+1;
                }
                else {
                    lookup[i][j] = Integer.min(lookup[i-1][j] +1, lookup[i][j-1]+1);
                }
            }
        }
        return lookup;
    }


    public void printShortestSuperSequence(String first, String second) {
        int[][] lookUp = fillLookUpTable(first, second);

        String scs = printSCS(first, first.length(), second, second.length(), lookUp);
        System.out.println(scs);

    }

    private String printSCS(String first, int m, String second, int n, int[][] lookUp) {
        if(m == 0) { // if we reached the end of first than return second
            return second.substring(0,n);
        }
        else if(n==0) {
            return first.substring(0,m);
        }

        if(first.charAt(m-1) == second.charAt(n-1)) {
            return printSCS(first, m-1, second, n-1, lookUp)+ first.charAt(m-1);
        }
        else {
            if(lookUp[m-1][n] > lookUp[m][n-1]) {
                return printSCS(first, m-1, second,n, lookUp)+first.charAt(m-1);
            }
            else {
                return printSCS(first, m, second, n-1, lookUp)+second.charAt(n-1);
            }
        }
    }

}
