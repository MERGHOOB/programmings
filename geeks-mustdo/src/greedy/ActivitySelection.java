package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
/*
https://practice.geeksforgeeks.org/problems/activity-selection/0
 */
public class ActivitySelection {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(bufferedReader.readLine());
        for(int test = 0; test<testcases; ++test) {

            int n = Integer.parseInt(bufferedReader.readLine());

            Activity[] activities = new Activity[n];
            String[] st = bufferedReader.readLine().split(" ");
            String[] et = bufferedReader.readLine().split(" ");

            int maxTime = 0;
            for(int i =0; i<n; i++) {

                int endTime = Integer.parseInt(et[i]);
                maxTime = Math.max(maxTime, endTime);
                activities[i] = new Activity(Integer.parseInt(st[i]), endTime);
            }
            Arrays.sort(activities, new ActivityComparator());

            int i = 0;
            int activitiesCompleted = 1;
            for(int j =1; j<activities.length; j++) {
                if(activities[j].startTime >= activities[i].endTime) {
                    activitiesCompleted++;
                    i = j;
                }

            }
            System.out.println(activitiesCompleted);


//            System.out.println(activityDone);
        }
    }

    private static class Activity  {
        private final int endTime;
        private final int startTime;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public int getStartTime() {
            return startTime;
        }
    }

    private static class ActivityComparator implements Comparator<Activity> {



        @Override
        public int compare(Activity o1, Activity o2) {

            return o1.endTime == o2.endTime ? o2.startTime - o1.startTime :o1.endTime - o2.endTime;

        }
    }
}
