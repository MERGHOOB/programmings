package string;

/**
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * <p>
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 */
public class LC8_StringToInteger {

    //Simple solution

    public int myAtoi1(String str) {

        int i = 0;
        StringBuilder result = new StringBuilder();
        boolean isNegative = false;
        boolean isPositive = false;
        while (i < str.length()) {

            if (str.charAt(i) != ' ') {

                // As we encounter a digit break the loop
                if (Character.isDigit(str.charAt(i))) {
                    break;
                }
                // if a non-space non-numerical character comes after '+', '-' return 0;
                if (isNegative || isPositive) {
                    return 0;
                }
                // if '-' encounterd, save this information, used at line#39 and #60
                //and append it to result
                if (str.charAt(i) == '-') {
                    result.append("-");
                    isNegative = true;
                    i++;
                    continue;
                }
                // if '-' encounterd, save this information, used at line#39 and #60
                // no need to append
                if (str.charAt(i) == '+') {
                    isPositive = true;
                    i++;
                    continue;
                }
                // if non-digit character encounter before digit started return 0;
                return 0;

            }
            // if after '+', '-' space is found return 0;
            if (isPositive || isNegative) {
                return 0;
            }

            i++;
        }

        // if already we surpass the length, it means no digit is present, return 0;
        if (i >= str.length()) {
            return 0;
        }


        // It is sured that either '+' or '-' or nothing is present before a number.
        // Following loop will stop if when non-numerical character encounterd
        while (i < str.length()) {

            if (!Character.isDigit(str.charAt(i))) {
                break;
            }
            result.append(str.charAt(i));
            i++;
        }

        try {
            return Integer.parseInt(result.toString()); // result overflows or does not contain number format
        } catch (NumberFormatException e) {
            // result overflows or does not contain number format, return based on information of negativeness max or minvalue
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

    }

    // 1 ms
    public int myAtoi(String str) {

        int total = 0;
        int sign = 1;

        int index = 0;

        while(index < str.length() && str.charAt(index) == ' ') {
            index ++;
        }

        if(index >=str.length()) {
            return 0;
        }
        //handle sign

        if(str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1: -1;
            index++;
        }

        while(index < str.length()) {

            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) {
                break;
            }

            //Handling overflow
            if(total > Integer.MAX_VALUE/10 || total == Integer.MAX_VALUE/10 && Integer.MAX_VALUE %10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total*10 + digit;
            index++;
        }
        return total * sign;
    }



    public static void main(String[] args) {

        System.out.println(new LC8_StringToInteger().myAtoi("2147483648"));

    }


}
