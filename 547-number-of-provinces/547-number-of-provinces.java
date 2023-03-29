class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        
        int ans = 0;
        
        for(int i = 0 ; i < n ; i++){
           ans+=dfs(isConnected,visited,i);
            
        }
        return ans;
    }
    
    
    public int dfs(int[][] isConnected, boolean[] visited , int node){
        if(visited[node])return 0;
        
        visited[node] = true;
        
        for(int i = 0 ; i < isConnected.length ; i++){
            if(isConnected[node][i] == 1){
                dfs(isConnected,visited,i);
            }
        }
        
        return 1;
    }
}