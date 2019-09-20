package md_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EquilibiriumPoint {

    public static void main(String [] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(bufferedReader.readLine());

        for(int test = 0 ; test< testcase; test++) {

            int size = Integer.parseInt(bufferedReader.readLine());


            String [] arrs =  bufferedReader.readLine().split("\\s+");
            int [] numbers = new int[size];

            int j = 0;
            int sum = 0;

            for(String ele: arrs) {
                numbers[j++] = Integer.parseInt(ele);
                sum += numbers[j-1];
            }

            int leftSum = 0;
            boolean found = false;

            for(int i = 0 ; i<size; i++) {

                sum -= numbers[i];
                if(sum == leftSum) {
                    System.out.println(i+1);
                    found = true;
                    break;
                }
                leftSum += numbers[i];
            }

            if(!found) {
                System.out.println(-1);
            }





        }




    }



}

