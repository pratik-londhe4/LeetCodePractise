class Solution {
    public int minimumLength(String s) {
     
        int left = 0;
        int right = s.length()-1;
        
        while(left < right && s.charAt(left) == s.charAt(right)){
            char ch = s.charAt(left);
            //move left forward
            while(left < right && s.charAt(left) == ch){
                left++;
            }
            //move right back
            while(left <= right && s.charAt(right) == ch){
                right--;
            }
        }
        
        return right-left+1;
    }
}