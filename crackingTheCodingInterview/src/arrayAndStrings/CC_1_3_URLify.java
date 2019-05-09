package arrayAndStrings;

/**
 * 1.3 URLify: Write a method to replace all spaces in a string with '%20: You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith "J 13
 * Output: "Mr%20John%20Smith"
 * Hints: #53, #7 78
 */
public class CC_1_3_URLify {

    private char[] urlify(char[] inputArray, int trueLength) {


        int spaceCount = 0;

        for (int i = 0; i < trueLength; i++) {

            if (inputArray[i] == ' ') {
                spaceCount++;
            }
        }


        int requiredLength = trueLength + 2 * spaceCount;

        if(trueLength < inputArray.length)
            inputArray[trueLength] = '\0'; // At the end of true String add null character as an end to string

        for (int i = trueLength - 1; i >= 0; i--) {
            if (inputArray[i] == ' ') {
                inputArray[--requiredLength] = '0';
                inputArray[--requiredLength] = '2';
                inputArray[--requiredLength] = '%';
                continue;
            }
            inputArray[--requiredLength] = inputArray[i];
        }


        return inputArray;
    }

    public static void main(String[] args) {

        char[] mr_john_smith = new CC_1_3_URLify().urlify("Mr John Smith    ".toCharArray(), 13);
        System.out.println(mr_john_smith);
    }

}
