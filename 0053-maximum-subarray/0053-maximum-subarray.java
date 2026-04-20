class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length;i++){
            int temp = currentSum + nums[i];
            if(temp < nums[i]){
                currentSum = nums[i];
            }else{
                currentSum = temp;
            }
            if(maxSum < currentSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}