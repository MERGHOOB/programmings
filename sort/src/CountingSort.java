public class CountingSort {

    /**
     * consider the maximum number is 10000
     */
    public void countingSort(int[] arr) {

        int maximumNumber = 10001;
        int[] counts = new int[maximumNumber];
        for (int i = 0; i <= maximumNumber; i++) {
            counts[i] = 0;
        }

        for (int ele : arr) {
            counts[ele]++;
        }
        int index = 0;
        for (int i = 0; i <= maximumNumber && index < arr.length; i++) {
            while (counts[i] != 0) {
                arr[index++] = i;
                counts[i]--;
            }
        }
    }

}
