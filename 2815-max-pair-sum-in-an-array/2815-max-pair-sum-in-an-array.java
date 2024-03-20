class Solution {
    public int maxSum(int[] nums) {
        
        int mapArr[] = new int[10];
        int ans = -1;
        
        for(int i = 0 ; i < nums.length ; i++){
            int maxDigit = 0;
            int temp = nums[i];
            while(temp != 0){
                int digit = temp%10;
                temp/=10;
               maxDigit =  digit > maxDigit ? digit : maxDigit ;
            }
            
            if(mapArr[maxDigit] != 0){
                
                int sum = mapArr[maxDigit] + nums[i];
                ans = sum > ans ? sum : ans;
            }
            if(nums[i] > mapArr[maxDigit] ){
                mapArr[maxDigit] = nums[i];
            }
            
                
    
            
        }
        return ans;
    }
}