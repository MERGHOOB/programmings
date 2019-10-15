package array;

import java.util.*;

/*
https://leetcode.com/problems/daily-temperatures/

Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class LC739_DailyTemperature {

    public static int[] dailyTemperatures(int[] T) {

        int[] res = new int[T.length];
        Map<Integer, Stack<Integer>> valueToIndex = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(T[0]);

        valueToIndex.put(T[0], new Stack<>());
        valueToIndex.get(T[0]).push(0);


        for(int i = 1; i<T.length; i++) {

            while(!stack.isEmpty() && T[i] > stack.peek()) {
                int pop = stack.pop();
                Integer poppedValueIndex = valueToIndex.get(pop).pop();
                res[poppedValueIndex] +=(i-poppedValueIndex);
            }
            stack.push(T[i]);
            if(!valueToIndex.containsKey(T[i])) {
                valueToIndex.put(T[i], new Stack<>());
            }
            valueToIndex.get(T[i]).push(i);


        }
        return res;

    }
    static class ArrayValue {
        int val;
        int index;
        ArrayValue(int val, int index) {
            this.val = val; this.index = index;
        }
    }
    //44ms and also extra space better than 0th app
    public static int[] dailyTemperatures1(int[] T) {

        int[] res = new int[T.length];

        Stack<ArrayValue> stack = new Stack<>();
        stack.push(new ArrayValue(T[0], 0));
        for(int i = 0; i<T.length; i++) {
            while (!stack.isEmpty() && T[i] > stack.peek().val) {
                ArrayValue pop = stack.pop();
                res[pop.index] = i - pop.index;
            }
            stack.push(new ArrayValue(T[i], i));
        }
        return res;
    }
    //42 but less space
    public static int[] dailyTemperatures2(int[] T) {

        int[] res = new int[T.length];

        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(0);

        for(int i = 0; i<T.length; i++) {
            while (!indexStack.isEmpty() && T[i] > T[indexStack.peek()]) {
                Integer pop = indexStack.pop();
                res[pop] = i - pop;
            }
            indexStack.push(i);
        }
        return res;
    }
    // Don't use stack, instead use of result array.
    //FASTEST: 4ms
    public static int[] dailyTemperatures3(int[] T) {

        int[] res = new int[T.length];

        for(int i = T.length-2; i>=0; i--) {
            if(T[i] < T[i+1]) {
                res[i] = 1;
            }
            //this elif can be removed as this case can be handled by else part
            else if(T[i] == T[i+1]) {
                res[i] = res[i+1] == 0? 0 : res[i+1]+1;
            }
            else {
                int k;
                for(k = i+1; k<T.length; k +=res[k]) {
                    if(T[k] > T[i]) {
                        res[i] = k-i;
                        break;
                    }
                    if(res[k] ==0) {
                        res[i] = 0;
                        break;
                    }
                }

                if(k == T.length ) {
                    res[i] = 0;
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int [] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int [] T = {73,71,71,71,69,72,76,73};
        int[] ints = dailyTemperatures(T);
        for(int val: ints) {
            System.out.print(val+" ");
        }
        System.out.println();
        ints = dailyTemperatures1(T);
        for(int val: ints) {
            System.out.print(val+" ");
        }
        System.out.println();
        ints = dailyTemperatures3(T);
        for(int val: ints) {
            System.out.print(val+" ");
        }
        System.out.println();
//        System.out.println(Arrays.asList(dailyTemperatures(T)));
    }



}
