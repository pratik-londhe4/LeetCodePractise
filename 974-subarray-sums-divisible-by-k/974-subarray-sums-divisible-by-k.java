class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        if(nums.length == 1 && nums[0]%k != 0)return 0;
        HashMap<Integer,Integer> hm = new HashMap();
        int sum = 0;
        hm.put(0,1);
        int ans = 0;
        
        for(int i = 0 ; i < nums.length ; i++){
            System.out.println(sum%k);
            sum+=nums[i];   
            int rem = sum%k;
            if(rem < 0)rem+=k;
            if(hm.containsKey(rem)){
                ans+=hm.get(rem);
            }
                      
            hm.put(rem , hm.getOrDefault(rem,0)+1);
            
        }
        
        return ans;
        
    }
}