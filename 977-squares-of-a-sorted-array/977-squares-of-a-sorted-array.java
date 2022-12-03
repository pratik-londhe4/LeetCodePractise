class Solution {
    public int[] sortedSquares(int[] nums) {
        int left= 0;
        int right = nums.length-1;
        int i = right;
        int [] result = new int[nums.length];
        
        while(left <= right){
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                result[i] = nums[right]*nums[right];
                right--;
            }else{
                result[i] = nums[left]*nums[left];
                left++;
            }  
            
            i--;
        }
        return result;
        
    }
}