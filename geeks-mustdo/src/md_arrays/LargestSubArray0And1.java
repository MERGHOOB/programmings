package md_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LargestSubArray0And1 {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(bufferedReader.readLine());

        for (int test = 0; test < testcase; test++) {

            int size = Integer.parseInt(bufferedReader.readLine());


            String[] arrs = bufferedReader.readLine().split("\\s+");
            int[] numbers = new int[size];

            int index = 0;
            for (String ele : arrs) {
                numbers[index++] = "0".equals(ele) ? 0 : 1;
            }

            System.out.println(new LargestSubArray0And1().maxLen(numbers));


        }


    }

    int maxLen(int[] numbers) {

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {

            sum += numbers[i] == 0 ? -1 : 1;

            if (sum == 0) {
                answer = Math.max(answer, i + 1);
            }

            if (map.containsKey(sum)) {
                answer = Math.max(answer, i - map.get(sum));
            } else
                map.put(sum, i);

        }

        return answer;


    }


}
