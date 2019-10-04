package search.ternary;

public class TernarySearch {

    public static int ternarySearch(int [] arr, int toFind) {


        int n = arr.length;
        int left = 0, right = n-1;

        while(left <=right) {

            int mid1 = left + (right-left)/3;
            int mid2 = right - (right-left)/3;

            if(arr[mid1] == toFind) {
                return  mid1;
            }
            if(arr[mid2] == toFind) {
                return mid2;
            }

            if(toFind < arr[mid1]) {
                right = mid1-1;
            }
            else if(toFind < arr[mid2]) {
                left = mid1+1;
                right = mid2-1;
            }
            else {
                left = mid1+1;
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums =  {2,3,5,6,7,8,9,12,13,14};
        for(int num: nums) {
            System.out.println(ternarySearch(nums, num));
        }
    }
}
