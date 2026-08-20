class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> List1 = new ArrayList<>();
        List<Integer> List2 = new ArrayList<>();
        List1.add(nums[0]);
        List2.add(nums[1]);
        for(int i=2; i<n;i++){
            if(List1.get(List1.size()-1) > List2.get(List2.size()-1)){
                List1.add(nums[i]);
            }else{
                List2.add(nums[i]);
            }
        }
        int k=0;
        for(int i =0; i < List1.size();i++){
            nums[k] = List1.get(i);
            k++;
        }
        for(int i=0;i<List2.size();i++){
            nums[k] = List2.get(i);
            k++;
        }
        return nums;
    }
}