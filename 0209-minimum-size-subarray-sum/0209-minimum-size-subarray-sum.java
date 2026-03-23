class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int right = 0; right < nums.length; right++){
            currentSum += nums[right];

            while(currentSum >= target){
                int windowSize = right - left +1;
                minLength = Math.min(minLength, windowSize);

                currentSum -= nums[left];
                left++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}