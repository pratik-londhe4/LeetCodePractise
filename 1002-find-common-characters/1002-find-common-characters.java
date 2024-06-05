class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        
        HashMap<Character,Integer> map = count(words[0]);
        
        for(int i =0 ; i < words.length ; i++){
            String currWord = words[i];
            HashMap<Character,Integer> currMap = count(currWord);
            
            
            for(int j = 0 ; j < words[0].length() ; j++){
                int min = Math.min(map.getOrDefault(words[0].charAt(j), 0), currMap.getOrDefault(words[0].charAt(j), 0));
                map.put(words[0].charAt(j), min);
            }
        }
        
                   


         for (Character c : map.keySet()){
             int curr = map.get(c);
             while(curr > 0){
                 ans.add(c + "");
                 curr--;
             }
         }
        
        return ans;
        
    }
    
    
 HashMap<Character,Integer> count(String word){
            HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < word.length() ; i++){
            int curr = map.getOrDefault(word.charAt(i), 0);
            map.put(word.charAt(i), curr+1);
        }
     
     
     return map;
    }
    
    
}