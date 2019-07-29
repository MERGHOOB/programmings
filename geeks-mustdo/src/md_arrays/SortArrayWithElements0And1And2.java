package md_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;

public class SortArrayWithElements0And1And2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        for (int testcase = 0; testcase < testCases; testcase++) {
            int size = Integer.parseInt(bufferedReader.readLine());

            String[] elements = bufferedReader.readLine().split("\\s+");

            int i = 0;
            int swapiIndex = 0, swapJIndex = size - 1;

            while (i <= swapJIndex) {

                if (elements[i].equals("0")) {
                    swap(elements, i, swapiIndex);
                    i++;
                    swapiIndex++;
                } else if (elements[i].equals("2")) {
                    swap(elements, i, swapJIndex);
                    swapJIndex--;
                } else {
                    i++;
                }


            }

            printElements(elements);
        }
    }

    private static void printElements(String[] elements) {
        StringJoiner stringJoiner = new StringJoiner(" ");

        Arrays.asList(elements).forEach(stringJoiner::add);
        System.out.println(stringJoiner);
    }

    private static void swap(String[] elements, int i, int j) {
        String temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }


}
