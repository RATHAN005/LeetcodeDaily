class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int sortedArray = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[sortedArray] != nums[i]) {
                sortedArray++;
                nums[sortedArray] = nums[i];
            }
        }

        return sortedArray + 1;
    }
}