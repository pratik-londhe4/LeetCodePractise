class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = findFirstIndex(nums,target);
        ans[1] = findLastIndex(nums,target);
        
        return ans;
    }
    
    int findFirstIndex(int[]arr , int target){
        int firstIndex = -1;
        int low = 0;
        int high = arr.length-1;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(arr[mid] == target){
                firstIndex = mid;
                high = mid-1;
            }else if(arr[mid] > target){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        
        return firstIndex;
    }
    
    int findLastIndex(int[]arr , int target){
         int lastIndex = -1;
        int low = 0;
        int high = arr.length-1;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(arr[mid] == target){
                lastIndex = mid;
                low = mid+1;
            }else if(arr[mid] > target){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        
        return lastIndex;
    }
}