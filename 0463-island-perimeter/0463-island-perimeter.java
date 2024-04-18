class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1)// found land
                {
                    return dfs(i,j,visited,grid);
                }
            }
        }
        return 0;
    }
    
    //dfs
    public int dfs(int r, int c, boolean[][] visited, int[][]grid){
       
        
        // water or boundry
        if( r >= grid.length || c >= grid[0].length || r < 0 || c < 0 || grid[r][c] == 0){
            return 1;
        }
         if(visited[r][c]){
            return 0;
        }
        
        // now go thoruh all directions;
        visited[r][c] = true;
        int perimeter = dfs(r, c+1, visited, grid);
        perimeter += dfs(r, c-1, visited, grid);
        perimeter += dfs(r+1, c, visited, grid);
        perimeter += dfs(r-1, c, visited, grid);
        
        return perimeter;
    }
}