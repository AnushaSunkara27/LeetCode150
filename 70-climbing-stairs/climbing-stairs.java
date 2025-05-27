class Solution {
    public int climbStairs(int n) {

        // Base cases:
        if (n == 0) return 1; // 1 way to stand at step 0 (do nothing)
        if (n == 1) return 1; // Only 1 way: 1 step

        // dp[i] = number of ways to reach step i
        int[] dp = new int[n + 1];

        dp[0] = 1; // one way to stay at start
        dp[1] = 1; // one way to reach step 1 (1 step)

        // Fill dp table from bottom-up
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // climb from i-1 or i-2
        }

        return dp[n];

        
        // int pre = 1;
        // int curr = 1;
        // int temp = 0;

        // for(int i=1; i<n; i++) {
        //     temp = curr;
        //     curr = curr+pre;
        //     pre = temp;
        // }
        // return curr;
    }

}