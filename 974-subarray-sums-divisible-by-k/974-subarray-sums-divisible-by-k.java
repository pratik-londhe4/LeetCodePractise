class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        //map for reminder 
        int[] hm = new int[k];
        hm[0] = 1;
        int ans = 0;
        
        int sum = 0;
        
        for(int i = 0 ; i < nums.length ; i++){
            sum+=nums[i];
            
            int rem = sum%k;
            if(rem < 0)rem+=k;
            ans+=hm[rem];            
            hm[rem]++;
        }
        
        return ans;
    }
}



