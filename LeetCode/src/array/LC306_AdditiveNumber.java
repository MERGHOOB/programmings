package array;

import java.math.BigInteger;

public class LC306_AdditiveNumber {


    private boolean isAdditiveNumber(String num) {

        if (num.length() < 3) {
            return false;
        }

        for (int i = 0; i <= num.length() / 2; i++) {

            //NO TRAILING ZERO: if very first character of string is '0' and size is greater than 1 then break;
            if (num.charAt(0) == '0' && i > 0) {
                break;
            }

            String first = num.substring(0, i + 1);

            //make sure remaing size is equal to or bigger than maximum of first and second
            //remaining size = num.length - j-1
            //first string size is i;
            // second string size is j-i

            for (int j = i + 1; Math.max(i, j - i) <= num.length() - j - 1; j++) {

                //NO TRAILING ZERO
                if (num.charAt(i + 1) == '0' && j > i + 1) {
                    break;
                }

                String second = num.substring(i + 1, j + 1);
                if (isValid(first, second, j + 1, num)) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean isValid(String first, String second, int start, String num) {
        if (num.length() == start) {
            return true;
        }
        BigInteger firstInt = new BigInteger(first);
        BigInteger thirdInt = firstInt.add(new BigInteger(second));
        String third = thirdInt.toString();

        return num.startsWith(third, start)
                && isValid(second, third, start + third.length(), num);
    }


    public static void main(String[] args) {
        System.out.println(new LC306_AdditiveNumber().isAdditiveNumber("0235"));
    }
}
