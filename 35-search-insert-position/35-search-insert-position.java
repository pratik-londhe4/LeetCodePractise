class Solution {
    public int searchInsert(int[] nums, int target) {
        //always check for the boundry cases
        if(target < nums[0]){
            return 0;
        }
        if(target > nums[nums.length-1]){
            return nums.length;
        }
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }
            
            if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}