class Solution {
    List<List<Integer>> ans;
    List<Integer> subset;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        subset = new ArrayList<>();
        dfs(0,nums);
        return this.ans;
    }
    
    public void dfs(int i, int[] nums){
        if(i >= nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
                
        // to add the element
        subset.add(nums[i]);
        dfs(i+1, nums);
        // or not to add the element
        subset.remove(subset.size() - 1);
        dfs(i+1, nums);
        
    }
}