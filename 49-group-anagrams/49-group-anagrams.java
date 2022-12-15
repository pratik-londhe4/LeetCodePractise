class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm = new HashMap();
        int n = strs.length;
        
        for(int i = 0 ; i < n ; i++){
            String original = strs[i];
            String sorted = sort(original);
            
            if(hm.containsKey(sorted)){
                List<String> old = hm.get(sorted);
                old.add(original);
                hm.put(sorted,old);
            }else{
                List<String> newList = new ArrayList();
                newList.add(original);
                hm.put(sorted,newList);
            }
        }
        
        List<List<String>> ans = new ArrayList();
        
        for(List<String> val : hm.values()){
            ans.add(val);
        }
        
        return ans;
    }
    
    String sort(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}