class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       
        int curr = 0;
        int available = 0;
        int start = 0;
        for(int i = 0 ; i < gas.length ;i++){
            available+=gas[i]-cost[i];
            curr+=gas[i]-cost[i];
            if(curr < 0){
                start = i+1;
                curr = 0;
            }
            
            }
        
        if(available < 0)return -1;
        return start;
            
      
    }
}