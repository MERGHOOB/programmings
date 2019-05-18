
/*
Heap Sort :   Given an array sort it using heap sort

Solution:
First convert the array to create the heap out of the array
Then move the next element to last position and do heapify to re-create the heap
with rest of the array element:
 */

/*
TEST CASES:
Null array o1
1 element array o1
2 element array o(1)
sorted array nlogn
reverse sorted array nlogn

 */

public class HeapSort {


    public void sort(int []arr) {
        if(arr == null)
        {
            return;
        }
        int middle = (arr.length+1)/2 -1;
        for (int i = middle; i >= 0; i--) {
            //First heapify all root possible which start from middle
            heapify(i, arr, arr.length);
        }

        for(int i = arr.length; i>=2; i--) {
            //swap with the last index
            swap(arr, 0, i-1);
            int rightBound =  i-2; // end index of considered array
            heapify(0, arr, rightBound); // now only need to heapify root as it is not
        }



    }

    /*
    heapify method: swap value with maximum value child and do heapify the child until no more child or maximum value obtained at parent
     */
    private void heapify(int i, int[] arr , int rightBound) {


       while(i <=rightBound-1) {
           int leftChildIndex = 2 * i + 1;
           int rightChildIndex = leftChildIndex + 1;

           if (leftChildIndex >= rightBound) {//no more child
               return;
           }

           if (rightChildIndex >= rightBound) {
               rightChildIndex = leftChildIndex;
           }

           if (arr[i] >= Math.max(arr[leftChildIndex], arr[rightChildIndex])) { // maximum value is present at parent
               return;
           }


           if (arr[leftChildIndex] > arr[rightChildIndex]) { // leftchild is to be swapped
               swap(arr, leftChildIndex, i); //swap
               i = leftChildIndex;  // new heapify index
           } else {
               swap(arr, rightChildIndex, i);
               i = rightChildIndex;
           }
       }

   }


    public void swap(int [] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int arr[] = {
//                -1,5,8,2,-6,-8,11,5
//                2,3,5,6,7
//                7,6,5,4,3
                0,56,32,35,64,23,5,69,2,72,12,40
//                1,2
//                2,0
//                1

        };
        hs.sort(arr);
        hs.sort(null);
        for(int a : arr){
            System.out.println(a);
        }
    }


}
