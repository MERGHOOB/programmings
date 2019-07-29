package md_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InversionInArray {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = getIntegerValueForString(bufferedReader.readLine());


        for(int testcase = 0; testcase<testCases; testcase++) {

            int size = getIntegerValueForString(bufferedReader.readLine());

            String elements [] = bufferedReader.readLine().split("\\s+");
            long [] numbers = new long[size];
            for(int i=0; i<size;i++) {
                numbers[i] = getIntegerValueForString(elements[i]);
            }

            long [] temp = new long[size];
            System.out.println(mergeSort(numbers,temp, 0, size-1));

        }




    }

    private static int mergeSort(long[] numbers, long[] temp, int start, int end) {

        int inversionCount = 0;

        if(end> start) {
            //devide in half
            int mid = start + (end - start) / 2;

            inversionCount += mergeSort(numbers, temp, start, mid);
            inversionCount +=mergeSort(numbers, temp, mid+1, end);

            inversionCount += merge(numbers,temp,start, mid+1, end);

        }
        return inversionCount;
    }

    private static int merge(long[] numbers, long[] temp, int start, int mid, int end) {
        int inversionCount = 0;

        int i = start,j=mid,k=start;
        while(i<mid && j<=end) {
            if(numbers[i] <= numbers[j]) {
                temp[k++] = numbers[i++];
            }
            else { //inversion point
                /*
                In merge process, let i is used for indexing left sub-array and j for right sub-array.
                 At any step in merge(), if a[i] is greater than a[j], then there are (mid – i) inversions.
                 because left and right subarrays are sorted,
                  so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j]
                 */
                inversionCount = inversionCount + (mid-i);
                temp[k++] = numbers[j++];
            }
        }

        while(i<mid) {
            temp[k++] = numbers[i++];
        }
        while(j<=end) {
            temp[k++] = numbers[j++];
        }
        for(i=start; i<=end; i++) {
            numbers[i] = temp[i];
        }
        return inversionCount;


    }

    private static int getIntegerValueForString(String value) throws IOException {
        return Integer.parseInt(value);
    }


}
