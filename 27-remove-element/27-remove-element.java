class Solution {
    public int removeElement(int[] nums, int val) {
        int left = nums.length-1;
        int right = nums.length-1;
        
        int result = nums.length;
        
        while(left >= 0){
            if(nums[left] == val){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left--;
                right--;
                result--;
            }else{
                left--;
            }
           
        }
        return result;
        
    }
}