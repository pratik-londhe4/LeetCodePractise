class Solution {
    
    List<List<String>> ans;
    List<String> part;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        part = new ArrayList<>();
        dfs(0,s);
        return ans;
    }
    
    
    public void dfs(int i, String s){
        if(i >= s.length()){
            ans.add(new ArrayList<String>(part));
            return;
        }
        
        System.out.println(part);
        for(int j = i ; j < s.length() ; j++){
            if(isPali(s,i,j)){
                part.add(s.substring(i,j+1));
                dfs(j+1,s);
                part.remove(part.size() -1);
            }
        }
        
    }
    
    public boolean isPali(String s, int i, int j){
        for(;i<=j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        
        return true;
    }
}