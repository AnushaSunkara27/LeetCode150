class Solution {
    public int searchInsert(int[] nums, int target) {

        int length = nums.length;
        
        int low = 0;
        int high = length-1;
        
        while( low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                low = mid+1;
            } else if(nums[mid] > target) {
                high =mid-1;
            } 
        }

        return low;
    }
}