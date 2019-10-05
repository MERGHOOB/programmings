package search.ternary;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniModelFunction {

    public int function(int x) {
        return 2*x*x -12*x + 7;
    }

    private int minimumValue(int start, int end) {

        while (end - start >=3) {//  as ternary search reduce the interval to 2/3 of its size;
            int mid1 = start + (end-start)/3;
            int mid2 = end - (end-start)/3;

            if(function(mid1) < function(mid2)) {
                end = mid2;
            }
            else {
                start = mid1;
            }

        }
        if(start == end) {
            return function(start);
        }
        else if(start + 1 == end) {
            return Integer.min(function(start), function(end));
        }
        else {
            return Integer.min(function(start), Integer.min(function(start+1), function(start+2)));
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("graphs/input.txt")));
        int cases = Integer.parseInt(bufferedReader.readLine());

        while(cases != 0) {
            String[] s = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            System.out.println(new UniModelFunction().minimumValue(start, end));

            cases--;
        }
    }


}
