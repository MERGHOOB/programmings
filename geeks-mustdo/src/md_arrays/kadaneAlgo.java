package md_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kadaneAlgo {
    public static void main(String[] args) throws IOException {
        //code

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < testcases; testcase++) {

            int size = Integer.parseInt(br.readLine());

            String[] elements = br.readLine().split("\\s+");

            int[] numbers = new int[size];
            int maxSum = Integer.MIN_VALUE;


            for (int i = 0; i < size; i++) {
                numbers[i] = Integer.parseInt(elements[i]);
            }

            System.out.println(doKadaneToGetMaximumSum(numbers, size));

        }

    }

    private static int doKadaneToGetMaximumSum(int[] numbers, int size) {


        int maxSumSoFar = numbers[0];
        int currentMaximumSum = numbers[0];

        for (int i = 1; i < size; i++) {
            currentMaximumSum = Math.max(numbers[i], currentMaximumSum + numbers[i]);
            maxSumSoFar = Math.max(maxSumSoFar, currentMaximumSum);
        }
        return maxSumSoFar;
    }
}