package md_arrays;


import java.util.*;
import java.lang.*;
import java.io.*;

public class MissingNumberInArray {

    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    int numberOfTest = Integer.parseInt(br.readLine());


    for( int i=0; i<numberOfTest ; i++) {

        int n = Integer.parseInt(br.readLine());

        if(n == 1) {
            System.out.println(n);
        }

        int currentIndex = 1;
        int total = currentIndex++;
        int cumilativeN = 0;

        String line = br.readLine();
        String[] strs = line.trim().split("\\s+");
        for (String value : strs) {
            cumilativeN ^= Integer.parseInt(value);

            total = total ^ currentIndex++;

        }


        System.out.println(total ^ cumilativeN);



    }

    }






}

/* TLE
int cumilativeN = (n*(n+1))/2;

        int sumOfArray = 0;

        while(n !=1) {

            sumOfArray += scanner.nextInt();
            n--;
        }


        System.out.println(cumilativeN - sumOfArray);

 */