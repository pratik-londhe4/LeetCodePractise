class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(0,0,nums);
        
    }
    
    public int dfs(int i, int sum, int[] nums){
        if(i == nums.length){
            return sum;
        }
        
        return dfs(i+1, sum ^ nums[i], nums) + dfs(i+1,sum,nums);
    }
}