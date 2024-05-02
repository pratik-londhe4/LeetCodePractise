class Solution {
    public int findMaxK(int[] nums) {
        
        int[] map = new int[1001];
        
        // map for all negative numbers
         for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < 0){
                 map[Math.abs(nums[i])] = nums[i];
            }
            
           
            
        }
        
        int max = -1;
        
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 0 && map[nums[i]] == -nums[i]){
                max = Math.max(max, nums[i]);
                
            }
            
           
            
        }
        
        return max;
    }
}