class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIndx = 0;
        int maxIndx = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] < nums[minIndx]) minIndx = i;
            if(nums[i] > nums[maxIndx]) maxIndx = i;
        }
        int left = Math.min(minIndx, maxIndx);
        int right = Math.max(minIndx, maxIndx);

        return Math.min((left+1)+(n-right),Math.min(right+1,n-left));
    }
}