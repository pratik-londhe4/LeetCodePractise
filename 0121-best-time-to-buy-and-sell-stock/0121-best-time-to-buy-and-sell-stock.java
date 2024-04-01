class Solution {
    public int maxProfit(int[] prices) {
        //brute force
        int maxProfit = 0;
        int minVal = Integer.MAX_VALUE;

        // let's first find minimum price to buy
        for(int i = 0; i < prices.length ; i++){
            //keep updating min val
            if(prices[i] < minVal){
                minVal = prices[i];
            }else if(prices[i]- minVal > maxProfit){
                maxProfit = prices[i]-minVal;
            }
        }
        return maxProfit;
    }
}