class Solution {
    public String minWindow(String s, String t) {
        int[] freqT = new int[256];
        int[] freqW = new int[256];
        
        for(int i = 0 ; i < t.length() ; i++){
            freqT[(int)t.charAt(i)]++;
        }
        String ans = "";
        int length = Integer.MAX_VALUE;
        
        //do loop using sliding window
        int p1 = 0;
        int p2 = 0;
        
        // freqW[(int)s.charAt(p2)]++;
        
        while(p2 < s.length()){
            //invalid window
            if(!isValid(freqT,freqW) && p2 < s.length()){
             
                freqW[(int)s.charAt(p2)]++;
                   p2++;
                
            }
            //if current window is valid then 
            
            while(isValid(freqT,freqW)){
                int currLength = p2-p1+1;
                if(currLength < length){
                    length = currLength;
                    ans = s.substring(p1,p2);
                }
                freqW[(int)s.charAt(p1)]--;
                p1++;
            }
            
           
        }
        
        return ans;
    }
    
    boolean isValid(int[] freqT , int[] freqW){
        for(int i = 0 ; i < freqT.length ; i++){
            if(freqW[i] < freqT[i]){
                return false;
            }
        }
        
        return true;
    }
}