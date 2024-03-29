class Solution {
    public long countSubarrays(int[] nums, int k) {
        // find max of nums
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max,nums[i]);
        }
        
        long ans = 0;
        int left = 0 ;
        int right = 0;
        int count = 0;
        while(right < nums.length){
            if(nums[right] == max)count++;
            while(count > k || (left <= right && count == k && nums[left] != max)){
                if(nums[left] == max){
                    count--;
                }
                left++;
            }
            
            if(count == k){
                ans+=left+1;
            }
            right++;
        }
      
        return ans;
        
    }
}