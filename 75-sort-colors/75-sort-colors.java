class Solution {
    public void sortColors(int[] nums) {
        int p1 = -1;
        int p2 = p1+1;
        int p3 = nums.length-1;
        
        while(p2 <= p3){
            
            if(nums[p2] == 2){
                swap(nums,p2,p3);
                p3--;
            }else if(nums[p2] == 0){
                p1++;
                swap(nums,p1,p2);
                p2++;
            }else{
                p2++;
            }
        }
        
    }
    
    public void swap(int []arr , int i , int j){
        int tmp  = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}