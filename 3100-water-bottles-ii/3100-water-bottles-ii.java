class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        int emptyBottles = numBottles;
        numBottles = 0;
        
        
        while(numExchange <= emptyBottles ){
            numBottles++;
            emptyBottles-=numExchange;
            numExchange++;
            if(numExchange > emptyBottles && numBottles != 0){
                // drink water man
                ans+=numBottles;
                emptyBottles+=numBottles;
                numBottles = 0;
            }
        }
        
        return ans+=numBottles;
    }
}