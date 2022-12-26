class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hs = new int[256];
        int max = 0;
        
        int p1 = 0;
        int p2 = 0;
        while(p2 < s.length()){
            char ch = s.charAt(p2);
            if(hs[(int)ch] == 0){
                hs[(int)ch]++;
                max = Math.max(max , (p2-p1+1));
                p2++;
            }else{
                hs[(int)s.charAt(p1)] = 0;
                p1++;
            }
        }
        
        return max;
    }
}