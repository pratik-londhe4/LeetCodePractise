class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap<>();
        int ans = 0;
        
        // 3 pointer sliding window
        int left_far = 0;
        int left_near = 0;
        
        for(int r = 0 ; r < nums.length ; r++){
            count.put(nums[r], count.getOrDefault(nums[r] , 0)+1);
            
            // if more than k distinct integers
            while(count.size() > k){
                count.put(nums[left_near], count.get(nums[left_near])-1);
                if(count.getOrDefault(nums[left_near], 0) == 0){
                    count.remove(nums[left_near]);
                }
                
                left_near++;
                left_far = left_near;
                
            }
            
            // if left_far count is > 1
            while(count.get(nums[left_near]) > 1){
                count.put(nums[left_near], count.get(nums[left_near]) -1);
                left_near++;
            }
            
            if( count.size() == k){
                ans+=left_near - left_far+1;
            }
        }
        return ans;
    }
}