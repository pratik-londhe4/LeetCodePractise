class Solution {
    public int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int ans = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j= 0 ; j < grid[0].length ; j++){
                if(grid[i][j] != 0){
                    ans = Math.max(ans,goldMax(grid,visited,i,j) );
                }
            }
        }
        
        return ans;
    }
    
    public int goldMax(int[][]grid, boolean[][] visited, int row, int col){
        if(row < 0 || row > grid.length-1 || col < 0 || col > grid[0].length-1){
            return 0;
        }
        
        if(visited[row][col]){
            return 0;
        }
        
        if(grid[row][col] == 0){
            return 0;
        }
        
        int gold = grid[row][col];
        visited[row][col] = true;
        
        int top = goldMax(grid, visited, row-1, col);
        int right = goldMax(grid, visited, row, col+1);
        int bottom = goldMax(grid, visited, row+1, col);
        int left = goldMax(grid, visited, row, col-1);
        
        
        int val[] = new int[]{top,right,bottom,left};
        Arrays.sort(val);
        
        gold+=val[val.length-1];
        
        visited[row][col] = false;
        return gold;
        
    }
}