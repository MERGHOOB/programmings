package dp;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class LC1235_MaximumProfitOnJobScheduling {

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//int startTime [] = {11,10,14,24,5,9,3,17,27,20};
//int endTime[] = {20,23,22,29,9,13,9,23,28,30};
//int profit [] = {2,2,3,2,4,3,4,4,7,2};
//        int[] startTime = {1,2,3,3};
//        int [] endTime = {3,4,5,6};
//        int [] profit = {50,10,40,70};
//
//        int[] startTime = {1,1,1};
//        int [] endTime = {2,3,4};
//        int [] profit = {5,6,4};

    int[] startTime = {1,2,3,4,6};
        int [] endTime = {3,5,10,6,9};
        int [] profit = {20,20,100, 70,60};

        System.out.println(jobScheduling(startTime, endTime, profit));


    }

    private static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for(int i = 0; i<n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, new JobComparator());

        long [] dp = new long[n];
        dp[0] = jobs[0].prof;

        for(int i = 1; i<n; i++) {

            long includeCurrentProfit = jobs[i].prof;
            int l = latestNonConflict(jobs, i);
            if(l !=-1) {
                includeCurrentProfit += dp[l]; // add profiit to the last
            }
            dp[i] = Long.max(includeCurrentProfit, dp[i-1]);
        }

        return (int) dp[n-1];
    }

    private static int latestNonConflict(Job[] jobs, int i) {
        for(int j = i-1; j>=0; j--) {
            if(jobs[j].end <= jobs[i].start) {
                return j;
            }
        }

        return -1;
    }

    private static class Job {
        long start, end, prof;
        Job(long start, long end, long profit) {
            this.start = start;
            this.end = end;
            this.prof = profit;
        }

        public String toString() {
            return this.start + " - " + end +" - " + prof ;
        }
    }

    private static class JobComparator implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {

            return Long.compare(o1.end, o2.end);

        }
    }
}
