class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] min_dist = precompute(grid);
         for(int i =0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
              System.out.print(min_dist[i][j] + " ");
            }
             System.out.println();
        }
        
        
        PriorityQueue<Integer[]> q = new PriorityQueue(new MyComparator());
        
        q.offer(new Integer[]{0,0,min_dist[0][0]});
        boolean visited[][] = new boolean[n][n];
        
         while(!q.isEmpty()){
            Integer[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            int dist = cell[2];
             
            if(r == n-1 && c == n-1){
                return dist;
            }
            
            // go in all directions
            
            if(inbound(r, c+1, n) && !visited[r][c+1]){
                q.offer(new Integer[]{r,c+1,Math.min(dist,min_dist[r][c+1])});
                visited[r][c+1] = true;
            }
              
            if(inbound(r, c-1, n) && !visited[r][c-1]){
                q.offer(new Integer[]{r,c-1,Math.min(dist,min_dist[r][c-1])});
                visited[r][c-1] = true;
            }
              
            if(inbound(r+1, c, n) && !visited[r+1][c]){
                q.offer(new Integer[]{r+1,c,Math.min(dist,min_dist[r+1][c])});
                visited[r+1][c] = true;
            }
              
            if(inbound(r-1, c, n) && !visited[r-1][c]){
                q.offer(new Integer[]{r-1,c,Math.min(dist,min_dist[r-1][c])});
                visited[r-1][c] = true;
            }
            
        }
        
        return 0;
        
    }
    
    
    public boolean inbound(int r, int c, int size){
        if(r < 0 || c < 0 || r > size-1 || c > size-1){
            return false;
        }
        
        return true;
    }
    
    public int[][] precompute(List<List<Integer>> grid){
        // get all theives
        int n = grid.size();
        Queue<Integer[]> q = new ArrayDeque<>();
        int distances[][] = new int[n][n];
        boolean visited[][] = new boolean[n][n];
        
        for(int i =0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid.get(i).get(j) == 1){
                    // found a theif
                    distances[i][j] = 0;
                    q.offer(new Integer[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()){
            Integer[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            int dist = cell[2];
            
            // go in all directions
            
            if(inbound(r, c+1, n) && !visited[r][c+1]){
                distances[r][c+1] = dist + 1;
                q.offer(new Integer[]{r,c+1,dist+1});
                visited[r][c+1] = true;
            }
              
            if(inbound(r, c-1, n) && !visited[r][c-1]){
                distances[r][c-1] = dist + 1;
                q.offer(new Integer[]{r,c-1,dist+1});
                visited[r][c-1] = true;
            }
              
            if(inbound(r+1, c, n) && !visited[r+1][c]){
                distances[r+1][c] = dist + 1;
                q.offer(new Integer[]{r+1,c,dist+1});
                visited[r+1][c] = true;
            }
              
            if(inbound(r-1, c, n) && !visited[r-1][c]){
                distances[r-1][c] = dist + 1;
                q.offer(new Integer[]{r-1,c,dist+1});
                visited[r-1][c] = true;
            }
            
        }
        
        return distances;
    }
    
    class MyComparator implements Comparator<Integer[]>{
        public int compare(Integer[] a, Integer[] b){
            if(a[2] > b[2]){
                return -1;
            }
            else if(a[2] < b[2]){
                return 1;
            }
            return 0;
        }
    }
}