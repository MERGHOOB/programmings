package math;
/*
Share
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class LC29_DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE ) {
            return 0;
        }

        if (Integer.MIN_VALUE == dividend && divisor == -1) {

            return Integer.MAX_VALUE;
        }

        int temp = 0;
        if (Integer.MIN_VALUE == dividend) {
            if (divisor > 0) {
                dividend += divisor;
                temp = -1;
            } else {
                dividend -= divisor;
                temp = 1;
            }
        }

        boolean sign = (dividend ^ divisor) > 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int currentDivisor = divisor;
        int idx = 1;
        int quotient = 0;
        while (currentDivisor < dividend) {
            dividend -= currentDivisor;
            quotient += 1;

            currentDivisor <<= 1;
            idx <<= 1;
            if (currentDivisor > dividend || currentDivisor < 0) {
                currentDivisor = divisor;
                idx = 1;
            }
        }

        quotient = sign ? quotient : -quotient;
        quotient += temp;
        return quotient;


    }

    public static void main(String[] args) {

    }


}
