class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend the current subarray or start new from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Update max found so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}