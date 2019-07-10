package md_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(bufferedReader.readLine());

        while (testcases-- != 0) {
            int sizeOfArray = Integer.parseInt(bufferedReader.readLine());

            List<String> leaders = new ArrayList<>();
            String[] elements =  bufferedReader.readLine().split("\\s+");

            int currentLeader = Integer.parseInt(elements[sizeOfArray-1]);
            leaders.add(elements[sizeOfArray-1]);


            for(int i = sizeOfArray-2 ; i>=0; i--) {

                if(Integer.parseInt(elements[i]) >= currentLeader) {
                    leaders.add(elements[i]);
                    currentLeader = Integer.parseInt(elements[i]);
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for(int i = leaders.size()-1; i>=0; i--) {
                stringBuilder.append(leaders.get(i));
                stringBuilder.append(' ');
            }
            System.out.println(stringBuilder);


        }

    }


}
