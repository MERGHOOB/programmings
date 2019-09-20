import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AGGRCOW {


    private static int largestMinimumDistance(int[] sortedStalls, int cows, int stalls) {

        int minDistance = 0;


        int start = 0;
        int end = sortedStalls[stalls-1];

        while (start < end) {

            int mid = (end + start) / 2;

            if (atLeast(mid, sortedStalls, cows, stalls)) {
                start = mid + 1;
                minDistance = mid;
            } else
                end = mid;

        }
        return minDistance;
    }

    private static boolean atLeast(int candidateDistance, int[] sortedStalls, int cows, int stalls) {

        int tempCow = 1;
        int prevStall = sortedStalls[0]; // first cow on first stall

        for (int i = 1; i < stalls; i++) {
            if (sortedStalls[i] - prevStall >= candidateDistance) {

                tempCow++;
                if (tempCow == cows)
                    return true;

                prevStall = sortedStalls[i];
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(bufferedReader.readLine().trim());
        for (int test = 0; test < tests; test++) {


            String[] inputs = bufferedReader.readLine().trim().split(" ");

            int stalls = Integer.parseInt(inputs[0].trim());
            int cows = Integer.parseInt(inputs[1].trim());

            int[] stallArrays = new int[stalls];
            for (int i = 0; i < stalls; i++) {
                stallArrays[i] = Integer.parseInt(bufferedReader.readLine().trim());
            }


            if(cows > stalls) {
                System.out.println("0");
                continue;
            }
            Arrays.sort(stallArrays);
            if (cows == 2) {
                System.out.println(stallArrays[stalls - 1] - stallArrays[0]);
            } else
                System.out.println(largestMinimumDistance(stallArrays, cows, stalls));

        }
    }


}
