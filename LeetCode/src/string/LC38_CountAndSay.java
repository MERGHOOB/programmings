package string;
/*
https://leetcode.com/problems/count-and-say/
 */
public class LC38_CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(30));
    }

    private static String countAndSay(int n) {

        StringBuilder finalString = new StringBuilder("1");
        if (n == 1) {

            return finalString.toString();
        }

        while (n > 1) {
            int count = 1;
            int charPointer = 1;
            StringBuilder temp = new StringBuilder("");
            while ( charPointer <= finalString.length()) {

                if ( charPointer >= finalString.length() ||
                        finalString.charAt(charPointer) != finalString.charAt(charPointer - 1)) {
                    temp.append(count);
                    temp.append(finalString.charAt(charPointer - 1));
                    count = 0;
                }


                charPointer++;
                count++;
            }
            finalString = temp;

            n--;
        }
        return finalString.toString();
    }
}
