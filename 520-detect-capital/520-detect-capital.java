class Solution {
    public boolean detectCapitalUse(String word) {
        int caps = 0;
        
        for(int i = 0 ; i < word.length() ; i++){
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                caps++;
            }
        }
        
        if(caps == 0 || caps == word.length() || (caps == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')){
            return true;
        }
        return false;
    }
}