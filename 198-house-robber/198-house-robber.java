class Solution {
    public int rob(int[] nums) {
        int rob1 = 0 , rob2 = 0;
        
      
        for(int i = 0 ; i < nums.length ; i++){
           int maxRob = Math.max(rob2 , rob1 + nums[i]);
            rob1 = rob2;
            rob2 = maxRob;
        }
        
        return rob2;
        
    }
}