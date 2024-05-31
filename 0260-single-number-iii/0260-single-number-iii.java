class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0;
        for(int i =0 ; i < nums.length ; i++){
            xor^=nums[i];
        }
        
        // find one of the different bits
        int diff = 1;
        
        while( (xor & diff) != diff ){
            diff<<=1;
        }
        
        // found the bit, add to groups
        int a = 0;
        int b = 0;
        
        for(int i =0; i < nums.length ; i++){
            if((nums[i] & diff) == diff){
                a^=nums[i];
            }else{
                b^=nums[i];
            }
        }
        
        return new int[]{a,b};
        
    }
}