package head.design;

import java.util.*;
/*
https://leetcode.com/problems/find-median-from-data-stream/
 */
class MedianFinder {

    /**
     * initialize your data structure here.
     */

    private double median;


    private PriorityQueue<Integer> minHeap, maxHeap;

    public MedianFinder() {
        median = 0;
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap
        minHeap = new PriorityQueue<>(); // minHeap
    }

    private void addNum(int num) {
        calculateMedian(num);

    }

    private void calculateMedian(int num) {

        if (maxHeap.size() == minHeap.size()) {

            if (minHeap.isEmpty()) {
                minHeap.add(num);
            } else {
                updateHeaps(num);
            }

        } else {
            updateHeaps(num);
        }

        if (minHeap.size() - maxHeap.size() >= 2) {
            maxHeap.add(minHeap.remove());
            return;
        }
        if (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.add(maxHeap.remove());
        }
    }

    private void updateHeaps(int num) {
        if (num > minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
    }

    private double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }


    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();


//        medianFinder.maxHeap.addAll(Arrays.asList(1,2,3));
//        System.out.println(medianFinder.maxHeap.peek());
//        medianFinder.minHeap.addAll(Arrays.asList(1,2,3));
//        System.out.println(medianFinder.minHeap.peek());

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */