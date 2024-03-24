class Solution {
    public int findDuplicate(int[] nums) {
       int freqArr[] = new int[1000001];
        for(int i = 0 ; i < nums.length ; i++){
            freqArr[nums[i]]++;
            if(freqArr[nums[i]] >= 2){
                return nums[i];
            }
            
        }
        return nums[0];
    }
}