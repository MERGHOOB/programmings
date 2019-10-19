package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class NMeetingInARoom {



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(bufferedReader.readLine());
        for(int test = 0; test<testcases; ++test) {

            int n = Integer.parseInt(bufferedReader.readLine());

            Meeting[] meetings = new Meeting[n];
            String[] st = bufferedReader.readLine().split(" ");
            String[] et = bufferedReader.readLine().split(" ");

            int maxTime = 0;
            for(int i =0; i<n; i++) {

                int endTime = Integer.parseInt(et[i]);
                maxTime = Math.max(maxTime, endTime);
                meetings[i] = new Meeting(Integer.parseInt(st[i]), endTime, i+1);
            }
            Arrays.sort(meetings, new MeetingComparator());

            int i = 0;
            System.out.print(meetings[i].index + " ");
            for(int j =1; j<meetings.length; j++) {
                if(meetings[j].startTime >= meetings[i].endTime) {
                    System.out.print(meetings[j].index + " ");
                    i = j;
                }

            }
            System.out.println();


//            System.out.println(activityDone);
        }
    }

    private static class Meeting {
        private final int endTime;
        private final int startTime;
        private final int index;
        Meeting(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }

        public int getEndTime() {
            return endTime;
        }

        public int getStartTime() {
            return startTime;
        }
    }

    private static class MeetingComparator implements Comparator<Meeting> {



        @Override
        public int compare(Meeting o1, Meeting o2) {

            return o1.endTime == o2.endTime ? o2.startTime - o1.startTime :o1.endTime - o2.endTime;

        }
    }
}
