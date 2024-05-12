class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length-2][grid.length-2];
        
        for(int i = 0 ; i < ans.length ; i++){
            for(int j = 0; j < ans.length ; j++){
                ans[i][j] = findMax(i,j,grid);
            }
        }
        
        return ans;
    }
    
    public int findMax(int row, int col, int[][] grid){
        
        int max = Integer.MIN_VALUE;
        
        for(int i = row ; i < row + 3 ; i++){
            for(int j = col ; j < col+3 ; j++){
                max = Math.max(max, grid[i][j]);
            }
        }
        
        return max;
    }
}