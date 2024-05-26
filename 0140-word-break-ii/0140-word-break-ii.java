class Solution {
    List<String> curr;
    List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        curr = new ArrayList<>();
        ans = new ArrayList<>();
        
        backtrack(0, s, dict);
        return ans;
    }
    
    public void backtrack(int i, String s, HashSet dict){
        
        if(i == s.length()){
            String[] arr = new String[curr.size()] ;
            curr.toArray(arr);
            ans.add(String.join(" ",arr));
            return;
        }
        
        
        
            for(int j = i ; j < s.length() ; j++){
            
                
                String word = s.substring(i,j+1);
                if(dict.contains(word)){
                     curr.add(word);
                     backtrack(j+1, s,dict);
                    curr.remove(curr.size()-1);
                }
        }
    }
    
}