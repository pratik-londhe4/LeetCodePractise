class Solution {
    public int minimumRounds(int[] tasks) {
      HashMap<Integer,Integer> hm = new HashMap();
        
        for(int i : tasks){
            hm.put(i , hm.getOrDefault(i , 0)+1);
        }
        
        int ans = 0;
        for(int i : hm.values()){
            if(i == 1)
                return -1;
            
            ans+=i/3;
            
            if(i % 3 != 0){
                ans++;
            }
        }      
            
        
        
        
        
        return ans;
    }
}