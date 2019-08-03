package md_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuyAndSellStocks {

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[1001];

        while (testCount-- != 0) {

            int size = Integer.parseInt(bufferedReader.readLine());

            String[] elements = bufferedReader.readLine().split(" ");
            for (int i = 0; i < size; i++) {
                numbers[i] = Integer.parseInt(elements[i]);
            }

            StringBuffer result = new StringBuffer();
            result.append(getResult(numbers, size));
            if(result.toString().isEmpty()) {
                System.out.println("No Profit");
            }
            else
            System.out.println(result);


        }
    }

    private static StringBuffer getResult(int[] numbers, int size) {

        StringBuffer stringBuffer = new StringBuffer();
        int max = Integer.MIN_VALUE;
        int min = numbers[0];
        int lastMinIndex = 0;
        int lastMaxIndex = 0;
        for (int i = 1; i < size; i++) {

            if (numbers[i - 1] > numbers[i]) {
                lastMaxIndex = i - 1;

                if (lastMaxIndex != lastMinIndex) {
                    stringBuffer.append("(").append(lastMinIndex).append(" ").append(lastMaxIndex).append(") ");
                }
                lastMinIndex = i;

            }

        }
        if (lastMinIndex < size - 1) {
            stringBuffer.append("(").append(lastMinIndex).append(" ").append(size - 1).append(") ");
        }
        return stringBuffer;

    }


}
