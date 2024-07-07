class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int emptyBottles = 0;
        int ans = 0;
            
        while(numBottles > 0){
            // drink all bottles
            ans+=numBottles;
            numBottles+=emptyBottles;
                        
            emptyBottles = numBottles%numExchange;
            numBottles = numBottles/numExchange;
            
        

        }
        
        
        return ans;
    }
}