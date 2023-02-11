class Solution {
    
    void buildPrefix(int[] arr , long[] prefix){
        prefix[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            prefix[i] = arr[i] + prefix[i-1];
        }
    }
    
    long rangeSum(long[] arr , int l, int r){
        int n = arr.length;
        if(l > n-1 || r < 0){
            return 0;
        }
        if(l-1 < 0){
            return arr[r];
        }else
        return arr[r] - arr[l-1];
    }
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        //get prefix sum for row 0
        long[] row0 = new long[n];
        buildPrefix(grid[0] , row0);
        
        //get prefix sum for row 1
        long[] row1 = new long[n];
        buildPrefix(grid[1],row1);
        
        long ans = Long.MAX_VALUE;;
        
        long max = Long.MIN_VALUE;
        
        for(int i = 0 ; i < n ; i++){
            long topRow = rangeSum(row0,i+1,n-1);
            long btmRow = rangeSum(row1,0,i-1);
            max = Math.max(topRow,btmRow);
            ans = Math.min(ans,max);
        }
        
        
        return ans;
    }
}