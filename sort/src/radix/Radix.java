package radix;

import org.omg.CORBA.INTERNAL;

public class Radix {

    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixsort(arr, n);
        for(int val: arr) {
            System.out.print(val+ " ");
        }
    }

    private static void radixsort(int[] arr, int n) {
        // Find maximum number to max Number of digits
        int maxNumber = getMax(arr);

        // Do counting Sort for every digit:
        // instead of passing digit number, exp is passed exp is 10^i

        for(int digitPlace =1; maxNumber/digitPlace > 0; digitPlace *=10) { // it gives the value of exp
            countSort(arr, n, digitPlace);
        }
    }

    private static void countSort(int[] arr, int n, int digitPlace) { // digit place is 1st , 10th, 100th....
        int[] output = new int[n];

        int[] countOnDigits = new int[10]; // count array only have 0-9 digits

        // store count of occurrences in count[]
        for(int i = 0; i<n; i++) {
            int digit = (arr[i] / digitPlace) % 10; // value of digit based on digit place
            countOnDigits[digit]++; // increment if digit found
        }
        // change count[i] so that count[i] now contains
        // acutal postion of this digit in output
        for(int i =1; i<10; i++) {
            countOnDigits[i] +=countOnDigits[i-1]; // it means for i th digit will come after i-1 digit counts exhausted.
        }

        // Fill the output array:
        for(int i = n-1; i>=0; i--) {
            int digit = (arr[i] / digitPlace) % 10;
            output[countOnDigits[digit] -1] = arr[i]; //  at digit: arr[i]/exp)%10 's count and less than 1, -1 is for as array index start from 0: and counts will start with at least 1;
            countOnDigits[digit]--; // it means one is placed then make it new position will be less than it
        }

        // copy the output array to arr:
        System.arraycopy(output, 0, arr, 0, n);


    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int num: arr) {
            max = Integer.max(max, num);
        }
        return max;
    }

}
