class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        for(int i = s.length()-1 ; i >= 0 ; i--){
            int length = 0;
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            
            while(i >= 0 && s.charAt(i) != ' '){
                length++;
                i--;
            }
            ans = length;
            break;
            
        }
        return ans;
    }
}