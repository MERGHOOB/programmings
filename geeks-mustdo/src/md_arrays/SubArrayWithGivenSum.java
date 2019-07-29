package md_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubArrayWithGivenSum {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(bufferedReader.readLine());

        for (int test = 0; test < testcase; test++) {

            String[] sizeAndSum = (bufferedReader.readLine()).split("\\s+");

            int size = Integer.parseInt(sizeAndSum[0]);
            int sum = Integer.parseInt(sizeAndSum[1]);

            String[] elements = bufferedReader.readLine().split("\\s+");

            int[] numbers = new int[size];
            for (int i = 0; i < size; i++) {
                numbers[i] = Integer.parseInt(elements[i]);
            }
            int startIndex = 0;
            int endingIndex = 0;

            int i = 0, j = 0;
            int currentWindowSum = 0;
            boolean found = false;
            while (i <= j && j < size) {


                while (j < size && currentWindowSum < sum) {
                    currentWindowSum += numbers[j++];
                }

                while (i <= j && currentWindowSum > sum) {
                    currentWindowSum -= numbers[i++];
                }

                if (currentWindowSum == sum) {
                    startIndex = i + 1;
                    endingIndex = j;
                    found = true;
                    break;
                }

            }

            System.out.println(found ? startIndex + " " + endingIndex : "-1");
        }


    }

}
