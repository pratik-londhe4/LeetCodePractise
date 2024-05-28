class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int cost[] = new int[s.length()];
        
        for(int i = 0 ; i < s.length() ; i++){
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        
        int l = 0;
        int costTill = 0;
        int ans = 0;
        
       for(int r = 0 ; r < s.length() ; r++){
           costTill+=cost[r];
           
           while(costTill > maxCost){
               costTill-=cost[l];
               l++;
           }
           
           ans = Math.max(ans, r-l+1);
       }
        
        return ans;
        
       
    }
}