class Solution {
    public boolean exist(char[][] board, String word) {
        // brute force with dfs
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        // go thorugh all board
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(dfs(board,visited,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
    * board : matrix of the board
    * word : the given word string
    * c : column number
    * r : row number
    * i : ith char in string word
    * visited : also need a way to keep track of visited locations
    */
    public boolean dfs(char[][] board,boolean[][] visited,  String word, int r, int c, int i ){
        // true condition
        if(i == word.length()){
            return true;
        }
        
        // exit conditions
        if(r < 0 || c < 0 ||
           r >=board.length  || c >=board[0].length ||
           board[r][c] != word.charAt(i) ||
          visited[r][c] == true){
            return false;
        }
        
        //go in all directions
        visited[r][c] = true;
        boolean res = dfs(board,visited,word,r+1,c,i+1) ||
                      dfs(board,visited,word,r-1,c,i+1) ||
                      dfs(board,visited,word,r,c+1,i+1) ||
                      dfs(board,visited,word,r,c-1,i+1);
        
        visited[r][c] = false;
        return res;
        
        
    }
}