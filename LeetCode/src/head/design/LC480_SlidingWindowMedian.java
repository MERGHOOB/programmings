package head.design;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class LC480_SlidingWindowMedian {
    private double median;


    private PriorityQueue<Double> minHeap, maxHeap;

    public LC480_SlidingWindowMedian() {

        Set<Integer> set = new TreeSet<>();
        ((TreeSet<Integer>) set).higher(1);
        median = 0;
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap
        minHeap = new PriorityQueue<>(); // minHeap
    }

    private void addNum(double num) {
        calculateMedian(num);

    }

    private void calculateMedian(double num) {

        if (maxHeap.size() == minHeap.size()) {

            if (minHeap.isEmpty()) {
                minHeap.add(num);
            } else {
                updateHeaps(num);
            }

        } else {
            updateHeaps(num);
        }

        doBalance();
    }

    private void doBalance() {
        if (minHeap.size() - maxHeap.size() >= 2) {
            maxHeap.add(minHeap.remove());
            return;
        }
        if (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.add(maxHeap.remove());
        }
    }

    private void updateHeaps(double num) {
        if (!minHeap.isEmpty() && num > minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
    }

    private double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return ((maxHeap.peek()) + minHeap.peek()) / 2;
        } else if (maxHeap.size() > minHeap.size()) {
            return  maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    public void removeNum(double num) {

        if(!maxHeap.isEmpty() && num <= maxHeap.peek()) {
            maxHeap.remove(num);
        }
        else {
            minHeap.remove(num);
        }
        doBalance();
    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[nums.length - k+1];
        for(int i = 0; i<k;i++) {
            addNum(nums[i]);
        }
        int index  = 0;
        result[index++] = findMedian();

        for(int i =1; i<=nums.length -k; i++) {
            removeNum(nums[i-1]);
            addNum(nums[i+k-1]);
            result[index++] = findMedian();
        }
    return  result;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{2147483647,1,2,3,4,5,6,7,2147483647};
        double[] doubles = new LC480_SlidingWindowMedian().medianSlidingWindow(nums, 2);
        for(double d: doubles) {
            System.out.println(d);
        }
    }
}
