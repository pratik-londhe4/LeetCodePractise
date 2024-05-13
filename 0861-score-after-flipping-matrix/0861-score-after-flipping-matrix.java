class Solution {
    public int matrixScore(int[][] grid) {
        
        // flip the rows that has 0 in most signficant position
        int rows = grid.length;
        int columns = grid[0].length;
        
        for(int i = 0 ; i < rows; i++){
            if(grid[i][0] == 0){
                //flip
                for(int j = 0 ; j < columns ; j++){
                   grid[i][j] =  grid[i][j] == 0 ? 1 : 0;
                }
            }
        }
        // flip columns that has most zeros
        for(int i = 0 ; i < columns ; i++){
            // check 1;s
            int count_one = 0;
            for(int j = 0 ; j < rows ; j++){
                if(grid[j][i] == 1){
                    count_one++;
                }
            }
            
            if(count_one < (rows - count_one)){
                for(int j = 0 ; j < rows ; j++){
                    grid[j][i] = grid[j][i] == 0 ? 1 : 0;
                }
            }
        }
        
        int ans = 0 ;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0 ; j < columns ; j++){
                ans+= grid[i][j] << (columns - 1-j);
            }
        }
        return ans;
    }
}