package techDelight;

import java.util.*;

public class ShortestCommonSuperSequence {

    public static void main(String[] args) {
        String first = "ABCBDAB";
        String second = "BDCABA";

        System.out.println(new ShortestCommonSuperSequence().scsLength(first, second));
        new ShortestCommonSuperSequence().printShortestSuperSequence(first, second);
        new ShortestCommonSuperSequence().printAllSCS(first, second);

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
        int[][] lookup = new int[m + 1][n + 1];

        for(int i= 0; i<=m; i++) {
            lookup[i][0] = i;
        }
        for(int j = 0; j<=n; j++) {
            lookup[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                } else {
                    lookup[i][j] = Integer.min(lookup[i - 1][j] + 1, lookup[i][j - 1] + 1);
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
        if (m == 0) { // if we reached the end of first than return second
            return second.substring(0, n);
        } else if (n == 0) {
            return first.substring(0, m);
        }

        if (first.charAt(m - 1) == second.charAt(n - 1)) {
            return printSCS(first, m - 1, second, n - 1, lookUp) + first.charAt(m - 1);
        } else {
            if (lookUp[m - 1][n] > lookUp[m][n - 1]) {
                return printSCS(first, m - 1, second, n, lookUp) + first.charAt(m - 1);
            } else {
                return printSCS(first, m, second, n - 1, lookUp) + second.charAt(n - 1);
            }
        }
    }


    private void printAllSCS(String first, String second) {
        int[][] lookUp = fillLookUpTable(first, second);
        PrintUtility.print(lookUp);
        List<String> allSCS = getAllSCS(first, first.length(), second, second.length(), lookUp);
//        List<String> allSCS = SCS(first,second, first.length(), second.length(), lookUp);
        Set<String> set = new HashSet<>(allSCS);
        set.stream()
//                .filter(str -> str.length()==9)
                .forEach(System.out::println);
    }
    // Function to return all SCS of substrings X[0..m-1], Y[0..n-1]
    public static List<String> SCS(String X, String Y, int m, int n, int[][] lookup)
    {
        // if we have reached the end of first string, create a list
        // containing second substring and return
        if (m == 0) {
            return Arrays.asList(Y.substring(0, n));
        }

        // if we have reached the end of second string, create a list
        // containing first substring and return
        else if (n == 0) {
            return Arrays.asList(X.substring(0, m));
        }

        // if last character of X and Y is same, it should occur
        // only one time in SSC
        if (X.charAt(m - 1) == Y.charAt(n - 1))
        {
            // find all SCS of substring X[0..m-2], Y[0..n-2]
            List<String> scs = SCS(X, Y, m - 1, n - 1, lookup);

            // append current character X[m - 1] or Y[n - 1] to all SCS of
            // substring X[0..m-2] and Y[0..n-2]

            List<String> res = new ArrayList<>();
            for (String str : scs) {
                res.add(str + X.charAt(m-1));
            }

            return res;
        }

        // we reach here when the last character of X and Y don't match

        // if top cell of current cell has less value than the left cell,
        // then append current character of string X to all SCS of
        // substring X[0..m-2], Y[0..n-1]

        if (lookup[m - 1][n] < lookup[m][n - 1])
        {
            List<String> scs = SCS(X, Y, m - 1, n,lookup);

            List<String> res = new ArrayList<>();
            for (String str : scs) {
                res.add(str + X.charAt(m-1));
            }

            return res;
        }

        // if left cell of current cell has less value than the top cell,
        // then append current character of string Y to all SCS of
        // substring X[0..m-1], Y[0..n-2]

        if (lookup[m][n - 1] < lookup[m - 1][n])
        {
            List<String> scs = SCS(X, Y, m, n - 1,lookup);

            List<String> res = new ArrayList<>();
            for (String str : scs) {
                res.add(str + Y.charAt(n - 1));
            }

            return res;
        }

        // if top cell value is same as left cell, then go in both
        // top and left directions

        // append current character of string X to all SCS of
        // substring X[0..m-2], Y[0..n-1]
        List<String> top = SCS(X, Y, m - 1, n,lookup);

        List<String> res = new ArrayList<>();
        for (String str : top) {
            res.add(str + X.charAt(m-1));
        }

        // append current character of string Y to all SCS of
        // substring X[0..m-1], Y[0..n-2]
        List<String> left = SCS(X, Y, m, n - 1,lookup);
        for (String str : left) {
            res.add(str + Y.charAt(n - 1));
        }

        return res;
    }
    private List<String> getAllSCS(String first, int m, String second, int n, int[][] lookUp) {

        if (m == 0) {
            return Collections.singletonList(second.substring(0, n));
        } else if (n == 0) {
            return Collections.singletonList(first.substring(0, m));
        }

        //IF the last character is same for both
        if (first.charAt(m - 1) == second.charAt(n - 1)) {
            List<String> allSCS = getAllSCS(first, m - 1, second, n - 1, lookUp);
            List<String> res = new ArrayList<>();
            for (String s : allSCS) {
                res.add(s + first.charAt(m - 1));
            }
            return res;
        }

        // if top is bigger than
        if (lookUp[m - 1][n] < lookUp[m][n - 1]) {
            List<String> allSCS = getAllSCS(first, m - 1, second, n, lookUp);


            List<String> res = new ArrayList<>();
            allSCS.forEach(str -> res.add(str + first.charAt(m - 1)));
            return res;
        }
        //if left is bigger than top
        else if (lookUp[m - 1][n] > lookUp[m][n - 1]) {
            List<String> allSCS = getAllSCS(first, m, second, n - 1, lookUp);
            List<String> res = new ArrayList<>();
            allSCS.forEach(str -> res.add(str + second.charAt(n - 1)));

            return res;
        }
        //if both are equal:
        else {
            List<String> res = new ArrayList<>();

            List<String> tops = getAllSCS(first, m - 1, second, n, lookUp);
            tops.forEach(str -> res.add(str + first.charAt(m - 1)));


            List<String> left = getAllSCS(first, m, second, n - 1, lookUp);
            left.forEach(str -> res.add(str + second.charAt(n - 1)));

            return res;
        }
    }

}
