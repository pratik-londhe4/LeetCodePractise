class Solution {
    public void sortColors(int[] nums) {
        
        
        //brute force
        for(int i = 0 ; i < nums.length ; i ++){
            for(int j = 0 ; j < nums.length ; j++){
                if(nums[j] > nums[i]){
                    //swap mfs
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}