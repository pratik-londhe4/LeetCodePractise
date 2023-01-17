class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if(target > nums[n-1])return n;
        int potential = -1;
        
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                potential = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return potential;
    }
}