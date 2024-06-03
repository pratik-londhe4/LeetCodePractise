class Solution {
    public int appendCharacters(String s, String t) {
        
        int left = 0 ;
        int right = 0;
        int ans = t.length();
        while(left < s.length() && right < t.length()){
            if(s.charAt(left) == t.charAt(right)){
                ans--;
                left++;
                right++;
            }else{
                left++;
            }
            
        }
        
        
        return ans;
    }
}