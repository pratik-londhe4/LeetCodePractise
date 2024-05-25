class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        // lets get the letters into hashmap 
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < letters.length ; i++){
            map.put(letters[i], map.getOrDefault(letters[i], 0)+1);
        }
        
       return backtrack(0,words,map,score);
    }
    
    public int backtrack(int i, String[] words, HashMap<Character,Integer> map, int[] score){
        if(i == words.length){
            return 0;
        }
        
        //not include the word
        int res = backtrack(i+1, words, map, score);
        //include the word
        
        if( can_form_word(words[i],map)){
            for(int j =0 ; j < words[i].length(); j++){
            map.put(words[i].charAt(j), map.getOrDefault(words[i].charAt(j), 0)-1);
        }
        res = Math.max(res, get_score(words[i],score) + backtrack(i+1,words,map,score));
          for(int j =0 ; j < words[i].length(); j++){
            map.put(words[i].charAt(j), map.getOrDefault(words[i].charAt(j), 0)+1);
        }
        }
        
        return res;
        
    }
    
    public boolean can_form_word(String word, HashMap<Character,Integer> map){
        HashMap<Character,Integer> letter_count = new HashMap<>();
        
        
        // map the letter count in words
        for(int i = 0 ; i < word.length() ; i++){
            letter_count.put(word.charAt(i), letter_count.getOrDefault(word.charAt(i),0)+1);
            
        }
        
        for(int i = 0 ; i < word.length() ; i++){
            if(letter_count.getOrDefault(word.charAt(i),0) > map.getOrDefault(word.charAt(i),0)){
                return false;
            }
        }
        
        return true;
    }
    
    public int get_score(String word,int[] score){
        int total = 0;
       for(int i = 0 ; i < word.length() ; i++){
           int index = word.charAt(i) - 'a';
           total+=score[index];
       }
        
        return total;
    }
}