class Solution {
    public int maxSubArray(int[] nums) {
        // int maxSum = nums[0];
        // int currSum = 0;

        // for(int i: nums) {
        //     if(currSum < 0) {
        //         currSum = 0;
        //     }
        //     currSum +=i;
        //     maxSum = Math.max(maxSum, currSum);
        // }
        // return maxSum;

/* The below solution is O(N^2) complexity/*
        // int maxSum = Integer.MIN_VALUE;
        // int n = nums.length;

        // for(int i=0; i<n; i++) {
        //     int sum = 0;
        //     for(int j=i; j<n; j++) {
        //         sum = sum+nums[j];
        //         maxSum = Math.max(sum, maxSum);
        //     }
        // }
        // return maxSum;
    }


/* */
    int maxSum = nums[0];
    int currSum = nums[0];

    for(int i=1; i<nums.length; i++) {
        currSum = Math.max(nums[i], currSum+nums[i]);
        maxSum = Math.max(currSum, maxSum);
    }
    return maxSum;
}
}