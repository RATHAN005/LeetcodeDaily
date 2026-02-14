class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maximumArea = 0;

        while(left < right){
            int width = right - left;
            int currentHeight = Math.min(height[left],height[right]);
            int currentArea = width * currentHeight;

            maximumArea = Math.max(maximumArea, currentArea);

            if(height[left] < height[right]){
                left++;

            }else{
                right--;
            }
        }
        return maximumArea;
    }
}