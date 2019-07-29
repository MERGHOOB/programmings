package md_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;

public class MajorityElement {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());

        int sizeOfArray;
        for (int test = 0; test < numberOfTestCases; test++) {
            sizeOfArray = Integer.parseInt(bufferedReader.readLine());

            String[] elements = bufferedReader.readLine().split("\\s+");

            int majority_index = 0;
            int count =1;

                for(int i = 1; i< sizeOfArray; i++) {

                    if(elements[majority_index].equals(elements[i])) {
                        count++;
                    }
                    else {
                        count--;
                    }

                    if(count == 0) {
                        majority_index = i;
                        count =1;
                    }

                }

                count = 0;
                for(int i = 0 ; i<sizeOfArray; i++) {
                    if(elements[majority_index].equals(elements[i])) {
                        count++;
                    }
                }

                if(count<<1 > sizeOfArray) {
                    System.out.println(elements[majority_index]);
                }
                else
                {
                    System.out.println("-1");
                }


        }


    }


}

/* TLE solution

   Map<Integer, Integer> map = new HashMap<>();
            boolean notFound = true;

            String[] elements = bufferedReader.readLine().split("\\s+");

            for (String element : elements) {

                int elementInt = Integer.parseInt(element);

                map.putIfAbsent(elementInt, 0);
                map.put(elementInt, map.get(elementInt) + 1);

                if ((map.get(elementInt) << 1) > sizeOfArray) {
                    notFound = false;
                    System.out.println(elementInt);
                    break;
                }
            }

            if (notFound) {
                System.out.println("-1");
            }

 */