package dp;


/*
If some element is last element, then it is the bridge between till end;

consider the fact: than new Array A is bigger than size 2;

i-1 i i+1 .... k-1 k k+1 ... j-1 j j+1

dp[i][j] = dp[i][k-1] + nums[i-1]*nums[k]*nums[j+1] + dp[k+1][j] for i<=k<=j

if i = k =  j; then what : dp[i][k-1] and dp[k+1][j] would be zero.

time per subproblem will be O(j-i) = O(n);


 */
/*
o(N ^ 3) time
o(N ^ 2) space
1. define subproblems
dp[i][j] : the maximum coins we can collect by bursting all the balloons in nums[i:j+1]
number of subproblems o(N ^ 2)
2. guess
What is the last balloon to burst in nums[i:j+1]
number of choices o(j - i + 1) or o(N)
3. relate subproblem solutions
i - 1, i, i + 1, ... , k - 1, k, k + 1, ..., j - 1, j, j + 1
       ---------------------     --------------------
              dp[i][k - 1]            dp[k + 1][j]

dp[i][j] = max(dp[i][k - 1] + nums[i - 1] * nums[k] * nums[j + 1] + dp[k + 1][j])  i <= k <= j
corner case: i == k == j, dp[i][i - 1] and dp[k + 1][j] initialized to zero --> same equation
time per subproblem o(j - i) or O(N)
4. topological order
length from 1 to n
5. original problem
1, X, ..., X    , X, 1      nums
0, 1, ..., n - 1, n, n + 1  index
   ----------------
      dp[1][n]
*/

public class LC312_BurstBalloons {


    private int maxCoinsWithMCM(int[] nums) {

        int originalLen = nums.length;
        int newLen = originalLen + 2;

        int[] A = new int[newLen];

        A[0] = 1;
        A[newLen - 1] = 1;

        System.arraycopy(nums, 0, A, 1, originalLen);
        int[][] dp = new int[newLen][newLen];
        for (int len = 2; len < newLen; len++) {
            for (int i = 1; i < newLen - len + 1; i++) {

                int j = i + len - 1;

                for (int k = i; k < j; k++) {
                    dp[i][j] = Integer.max(dp[i][j], dp[i][k] + dp[k + 1][j] + A[i - 1] * A[k] * A[j]);

                }

            }
        }
        return dp[1][newLen - 1];


    }

    public int maxCoins(int[] nums) {


        int originalLen = nums.length;
        int newLen = originalLen + 2;

        int[] A = new int[newLen];

        A[0] = 1;
        A[newLen - 1] = 1;

        System.arraycopy(nums, 0, A, 1, originalLen);

        int[][] dp = new int[newLen][newLen];

        for (int len = 1; len <= originalLen; len++) { // for each subset

            // i + length -1 = orginalLen for right most position
            for (int i = 1; i <= originalLen - len + 1; i++) {
                int j = i + len - 1; // last index of subset start from i;
                for (int k = i; k <= j; ++k) {

                    // as i, j, dp[i][k-1] and dp[k+1][j] will be zero fro i==j == k;
                    dp[i][j] = Integer.max(dp[i][j], dp[i][k - 1] + A[i - 1] * A[k] * A[j + 1] + dp[k + 1][j]);
                }
            }

        }


        return dp[1][originalLen];


    }

    private int getValueAt(int[] nums, int k) {
        if (k < 0 || k >= nums.length) {
            return 1;
        }
        return nums[k];
    }


    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};

        System.out.println(new LC312_BurstBalloons().maxCoinsWithMCM(nums));
    }


}
