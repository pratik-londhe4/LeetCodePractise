class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
     
        //just do bfs and find if we can reach the destination
        //create graph first
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)graph.add(new ArrayList<>());
        
        for(int [] i  : edges){
            int u = i[0];
            int v = i[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(source);
        boolean visited[] = new boolean[n];
        
        while(!q.isEmpty()){
            int curr = q.remove();
            if(curr == destination)return true;
            if(visited[curr])continue;
            
            visited[curr] = true;
            
            //traverse neighbours
            for(int i : graph.get(curr)){
                if(!visited[i]){
                    q.add(i);
                }
            }
        }
        return false;
    }
}