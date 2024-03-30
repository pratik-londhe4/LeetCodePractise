class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        //brute force
        int hashMap[] = new int[256];
        for(int i =0 ; i < allowed.length() ; i++){
            hashMap[allowed.charAt(i)] = 1;
        }
        
        int ans = 0;
        for(int i = 0 ; i < words.length ; i++){
            boolean flag = true;
            for(int j = 0 ; j < words[i].length() ; j++){
                if(hashMap[words[i].charAt(j)] == 0){
                    flag = false;
                }
            }
            if(flag)ans++;
        }
        
        return ans;
    }
}