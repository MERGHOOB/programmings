

//Given a 32-bit signed integer, reverse digits of an integer.

public class LC7_Reverse_Integer {

    //For 10 digit it is not working
    public static int reverse1(int x) {

        String s = String.valueOf(x);

        StringBuilder stringBuilder = new StringBuilder();
        int end = 0;
        if (x < 0) {
            end = 1;
            stringBuilder.append("-");
        }
        for (int i = s.length() - 1; i >= end; i--) {

            stringBuilder.append(s.charAt(i));
        }


        return Integer.valueOf(stringBuilder.toString().trim());


    }

    // USE OF Hack
    public static int reverse2(int x) {


        double rev = 0;
        while (x != 0) {
            int remainder = x % 10;

            x = x / 10;

            rev = rev * 10 + remainder;
        }

        if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) rev;


    }

    // Actual
    private static int reverse(int x) {


        int rev = 0;
        while (x != 0) {
            int remainder = x % 10;

            x = x / 10;

            if ((rev > Integer.MAX_VALUE / 10) || (rev == Integer.MAX_VALUE / 10 && x > 7))
                return 0; // MORE THAN 7 need more bit, which throw stack overflow
            if ((rev < Integer.MIN_VALUE / 10) || (rev == Integer.MIN_VALUE / 10 && x < -8))
                return 0; // LESS THAN -8 need more bit, which throw stack overflow

            rev = rev * 10 + remainder;
        }

        return rev;

    }

    public static void main(String[] args) {


        System.out.println(reverse(120));

    }


}
