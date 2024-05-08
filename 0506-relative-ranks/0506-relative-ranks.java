class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] sorted = score.clone();
        Arrays.sort(sorted);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < sorted.length ; i++){
            map.put(sorted[i], sorted.length - i); 
        }
        
        String ans[] = new String[score.length];
        
        for(int i = 0 ; i < ans.length ; i++){
            int rank = map.get(score[i]);
            
            switch(rank){
                case 1 : 
                    ans[i] = "Gold Medal";
                    break;
                case 2:
                    ans[i] = "Silver Medal";
                    break;
                case 3:
                    ans[i] = "Bronze Medal";
                    break;
                default:
                    ans[i] = rank + "";
            }
        }
        
        return ans;
    }
}