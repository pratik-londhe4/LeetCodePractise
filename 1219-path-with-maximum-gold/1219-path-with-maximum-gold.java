class Solution {
    public int getMaximumGold(int[][] grid) {
        
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] != 0){
                    ans = Math.max(ans, getGold(grid,visited,i,j));
                }
            }
        }
        
        return ans;
        
        
    }
    
    public int getGold(int[][] grid, boolean[][] visited, int row, int col){
        // check bounds
        if( row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1){
            return 0;
        }
        // if visited
        if(visited[row][col]){
            return 0;
        }
        
        // if 0 gold
        if(grid[row][col] == 0){
            return 0;
        }
        
        
        int gold = grid[row][col];
        
        visited[row][col] = true;
        
        int top = getGold(grid,visited,row-1,col);
        int left = getGold(grid,visited,row,col-1);
        int bottom = getGold(grid,visited,row+1,col);
        int right = getGold(grid,visited,row,col+1);
        
        
        int [] results = new int[]{top,left,bottom,right};
        Arrays.sort(results);
        
        gold+=results[results.length -1];
        
        visited[row][col] = false;
        
        return gold;
        
        
    }
    
}