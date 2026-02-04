class Solution {
    public int maxProfit(int[] prices) {
        int MinPrice = Integer.MAX_VALUE;
        int MaxPrice = 0;
        for(int i =0; i<prices.length;i++){
            if(prices[i]<MinPrice){
                MinPrice = prices[i];
            }
            else{
               
                    int profit =  prices[i]-MinPrice ;
                     if(profit >MaxPrice){
                        MaxPrice = profit;
                }
            }
        }
        return MaxPrice;
    }
}