package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
https://practice.geeksforgeeks.org/problems/coin-piles/0
 */
public class CoinPiles {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        for(int test = 0; test< testCases; test++) {

            String[] s = bufferedReader.readLine().split(" ");
            int n  = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            int[] piles = new int[n];
            String[] s2 = bufferedReader.readLine().split(" ");
            for(int i = 0; i<n; i++ ) {
                int val = Integer.parseInt(s2[i]);
                piles[i] = val;
            }

            Arrays.sort(piles);
            int minCoinRequired = Integer.MAX_VALUE;
            int lastRemovedCoinsFromPiles = 0; //if piles is removed, then add that pile coins to
            for(int i = 0; i<n; i++) {
                int tempCount = lastRemovedCoinsFromPiles;
                lastRemovedCoinsFromPiles += piles[i];
                for(int j = n-1; j>i; j--) {
                    if(piles[j] - piles[i] > k) {
                        tempCount += (piles[j]-piles[i]-k);
                    }
                }

                minCoinRequired = Integer.min(minCoinRequired, tempCount);
            }
            System.out.println(minCoinRequired);
        }
    }

}
