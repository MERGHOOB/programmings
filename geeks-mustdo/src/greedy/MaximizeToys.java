package greedy;
/*
https://practice.geeksforgeeks.org/problems/maximize-toys/0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MaximizeToys {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(bufferedReader.readLine());
        for(int test = 0 ; test < testCases; test++) {

            String[] s = bufferedReader.readLine().split(" ");
            int n  = Integer.parseInt(s[0]);
            int money = Integer.parseInt(s[1]);

            s = bufferedReader.readLine().split(" ");
            Arrays.sort(s, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2)); // mulitple parsing
                }
            });

            int count = 0;
            for(String string: s) {
                money -= Integer.parseInt(string); // second time parsing one can store values in int array and than sort.
                if(money <0) {
                    break;
                }
                count++;
            }

            System.out.println(count);

        }
    }

}
