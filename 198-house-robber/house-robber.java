class Solution {
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        if(nums.length == 1) return nums[0];

        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[n-1];


    //   int n = nums.length;
    //   int[] dp = new int[n+1];

    //   Arrays.fill(dp, -1);

    //   dp[0] = nums[0];

    //   for(int i = 1; i< n; i++) {
    //     int pick = nums[i];

    //     if(i>1) {
    //       pick += dp[i-2];
    //     }
    //     int nonPick = dp[i-1];
    //     dp[i] = Math.max(pick, nonPick);
    //   }

    //   return dp[n-1];

    }
}