class Solution {
    public int[] shuffle(int[] nums, int n) {
        int first = 0;
        int second = n;
        
        int[]ans = new int[nums.length];
        
        for(int i = 0 ; second < ans.length; i++){
            
            if(i%2 == 0){
                ans[i] = nums[first];
                first++;
            }else{
                ans[i] = nums[second];
                second++;
            }
        }
        
        return ans;
    }
}