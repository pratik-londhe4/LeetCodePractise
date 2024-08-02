class Solution {
    public int minSwaps(int[] nums) {
        
        int n = nums.length;
        int total_ones = 0;
        for(int i : nums){
            total_ones+=i;
        }
        
        
        
        int window_ones = 0;
        int window_max_ones = 0;
        int left = 0;
        
        
        for(int right = 0 ; right < n*2 ; right++){
            if(nums[right%n] == 1){
                window_ones+=1;
            }
            
            if(right-left + 1  > total_ones){
                window_ones-=nums[left % n];
                left++;

            }
            
                window_max_ones = Math.max( window_max_ones , window_ones );
            
        }
        
        return total_ones - window_max_ones;
        
        
        
        
    }
}