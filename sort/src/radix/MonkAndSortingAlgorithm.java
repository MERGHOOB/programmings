package radix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
https://www.hackerearth.com/practice/algorithms/sorting/radix-sort/practice-problems/algorithm/monk-and-sorting-algorithm/
Monk recently taught Fredo about sorting. Now, he wants to check whether he understood the concept or not. So, he gave him the following algorithm and asked to implement it:

Assumptions:
We consider the rightmost digit of each number to be at index 1, second last at index 2 and so on till the leftmost digit of the number.
Meaning of  i-th chunk: This chunk consists of digits from position 5*i to 1+ 5*(i-1)  in the given number.If there is no digit at some position in the number, take the digit to be 0.

    Initially, i is 1.

    Construct the  i-th chunk, for all of the integers in the array. Let's call the value of this chunk to be the weight of
    respective integer in the array.

    If weight of all the integers of the array is 0, then STOP

    Sort the array according to the weights of integers. If two integers have same weight, then the one which appeared earlier should be positioned earlier after the sorting is done. The array changes to this sorted array.

    Increment i by 1 and repeat from STEP 1

See the sample explanation for a better understanding.
So, Fredo understood the concept and coded it. Now, Monk asks you to write the code for the algorithm to verify Fredo's answer.
Sample Input:
3
213456789 167890 123456789

Output:
213456789 123456789 167890
167890 123456789 213456789


 */
public class MonkAndSortingAlgorithm {


    public static final int EXP = 100000;
    static long arr[] , output[];
    static PrintWriter printWriter;
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

         */
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());                // Reading input from STDIN
        arr = new long[n]; output = new long[n];
        String[] splits = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i] = Long.parseLong(splits[i].trim());
        }
        printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        // Write your code here

//        arr =  {213456789, 167890, 123456789};

        sortBasedOnChunks();
        printWriter.close();



    }

    private static void sortBasedOnChunks() {
        int maxValue = getMax(arr);

        //Get the chunk of 5 digits together and next exp : 10^5, 10^20
        for(long digitPlace=1; maxValue/digitPlace> 0; digitPlace*=EXP) {
            countSort(arr, arr.length, digitPlace);

        }
    }



    private static void countSort(long[] arr, int n, long place) {


        int[] countOfDigits = new int[EXP]; //digits are 0-9 only

//        int place = (int) Math.pow(10, digitPlace-1);
        //Fill counts of Digits:
        for(int i=0; i<n; i++) {
            int digit = (int) ((arr[i]/place)%EXP);
            countOfDigits[digit]++;
        }

        //Fill the acutal position
        for(int i=1; i<EXP; i++) {
            countOfDigits[i] +=countOfDigits[i-1];
        }

        //Fill the output array:
        for(int i=n-1; i>=0; i--) {
            int digit = (int) ((arr[i]/place)%EXP);
            output[countOfDigits[digit]-1] = arr[i];
            countOfDigits[digit]--;
        }

        // update array:
        for(int i =0; i<n;i++) {

            arr[i] = output[i];
            printWriter.print(arr[i] + " ");
        }
        printWriter.println();
        System.arraycopy(output, 0, arr, 0, n);

    }


    private static int getMax(long [] arr) {
        int max = Integer.MIN_VALUE;
        for(long val: arr) {
            max = Integer.max((int)val, max);
        }
        return max;
    }


}
