class Solution {
    
     boolean  has_cache[][][];
    int cache[][][] ; 
     private static final int MOD = 1000000007;
       
    public int checkRecord(int n) {
        
       
        cache  = new int[n][3][3];
        has_cache = new boolean[n][3][3];
        return recurse(n,1,0,n);        
       
     }
    
    public int recurse(int i, int absents, int late, int n){
        
        if( i== 0){
            return 1;
        }
        
        if(has_cache[i-1][absents][late]){
            return cache[i-1][absents][late];
        }
        
        int ans = recurse(i-1,absents,0,n);
        if(absents > 0 ){
            ans+= recurse(i-1,absents-1,0,n);
        }
        ans = ans%MOD;
        
        if(late < 2){
            ans+= recurse(i-1,absents,late+1,n);
        }
        
        has_cache[i-1][absents][late] = true;
        cache[i-1][absents][late] = ans % MOD;
        
        return ans % MOD;
    }
}