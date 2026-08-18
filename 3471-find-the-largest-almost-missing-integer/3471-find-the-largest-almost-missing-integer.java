class Solution {
    public int largestInteger(int[] nums, int k) {
        int v=-1,n=nums.length;
        
        int[] c=new int[51];
        for(int i:nums) c[i]++;
        if(k==1){
            for(int i:nums) if(c[i]==1) v=Math.max(v,i);
        }else if(k==n){
            for(int i:nums) v=Math.max(v,i);
        }
        else{
        if(c[nums[0]]==1) v=nums[0];
        if(c[nums[n-1]]==1) v=Math.max(v,nums[n-1]);
        }
        return v;
    }
}