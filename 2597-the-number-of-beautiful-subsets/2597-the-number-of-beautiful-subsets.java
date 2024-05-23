class Solution {
    
    //int ans = 0;
    public int beautifulSubsets(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        return dfs(0,nums,map,k)-1;
    }
    
    public int dfs(int i, int[] nums, HashMap<Integer,Integer> map, int k){
        if(i == nums.length){
            return 1;
        }
        
        int ans = dfs(i+1,nums,map, k);
        if(map.getOrDefault(nums[i]+k, 0) == 0 && map.getOrDefault(nums[i]-k, 0) == 0){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            ans+= dfs(i+1, nums,map,k);
             map.put(nums[i], map.get(nums[i]) - 1);

        }
        
        return ans;
        
        
    }
}