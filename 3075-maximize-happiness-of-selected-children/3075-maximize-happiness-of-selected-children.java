class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        
        long ans = 0;
        int turn = 0;
        
        for(int i = happiness.length-1; k > 0 ; i--){
            
            ans+= happiness[i] - turn > 0 ? happiness[i] - turn : 0 ;
            turn++;
            k--;
        }
        
        return ans;
    }
}