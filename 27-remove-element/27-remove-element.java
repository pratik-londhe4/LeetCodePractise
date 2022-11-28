class Solution {
    public int removeElement(int[] nums, int val) {
        int left = nums.length-1;
        int right = nums.length-1;
        
        int result = nums.length;
        
        while(left >= 0){
            if(nums[left] == val){
              swap(nums,left,right);                
                left--;
                right--;
                result--;
            }else{
                left--;
            }
           
        }
        return result;
        
    }
    
    public void swap(int[] arr , int i , int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}