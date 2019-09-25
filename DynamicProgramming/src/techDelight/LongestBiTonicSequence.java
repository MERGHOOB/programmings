package techDelight;

public class LongestBiTonicSequence {

    static int lbs(int[] arr, int size) {

        if(arr == null || arr.length ==0) {
            return 0;
        }
       /*
        calculate increasing Sequence array at each index;
        */
        int[] increasingSequence = new int[size]; // all size is 0 initially. (java default do this for us)
        increasingSequence[0] = 1; // with one element, size of lIS will be 1;

        for (int i = 1; i < size; i++) { // length
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && // to include ith value in sequence; it should be greater than jTh value
                        increasingSequence[i] < increasingSequence[j]) // and sequence lenth on i should be less than on j
                {
                    increasingSequence[i] = increasingSequence[j]; // include jth length
                }
            }
            increasingSequence[i]++; // to make sure at length 1, if it is not include anywhere.
        }


       /*
        calculate increasing Sequence array at each index;
        */
        int[] decreasingSequence = new int[size];
        System.out.println(decreasingSequence[0]);
        int lastIndex = size - 1;
        decreasingSequence[lastIndex] = 1;

        for (int i = lastIndex - 1; i >= 0; i--) {
            for (int j = lastIndex; j > i; j--) {
                if (arr[j] < arr[i] && // to include ith value in sequence; it should be greater than jTh value
                        decreasingSequence[i] < decreasingSequence[j]) // and sequence lenth on i should be less than on j
                {
                    decreasingSequence[i] = decreasingSequence[j]; // include jth length
                }

            }
            decreasingSequence[i]++; // to make sure at length 1, if it is not include anywhere.
        }

//        PrintUtility.print(decreasingSequence);
//        PrintUtility.print(increasingSequence);
        int lbs = 1;
        for (int i = 0; i < size; i++) {
            lbs = Integer.max(lbs, increasingSequence[i] + decreasingSequence[i] - 1);
        }

        return lbs;
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
                13, 3, 11, 7, 15};
        int n = arr.length;
        System.out.println("Length of LBS is " + lbs(arr, n));
    }


}
