class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;
        
        // loop thorugh the tickets, 
        for(int i = 0 ; i < tickets.length ; i++){
            // people before k or k
            if(i <= k){
                res+=Math.min(tickets[i], tickets[k]);
            }
            // people after k
            else if(i > k){
                res+=Math.min(tickets[i], tickets[k]-1);
            }
        }
        return res;
    }
}