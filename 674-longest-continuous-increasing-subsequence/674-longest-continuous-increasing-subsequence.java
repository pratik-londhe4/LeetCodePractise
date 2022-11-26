class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int count = 1;
        
        for(int i = 0 ; i < nums.length-1 ; i++){
            if(nums[i] < nums[i+1])count++;
            else{
            max = Math.max(max,count);
                count = 1;
            }
        }
        
        return Math.max(max,count);
    }
}