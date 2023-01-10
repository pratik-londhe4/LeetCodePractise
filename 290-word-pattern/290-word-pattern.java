class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> hm = new HashMap();
        HashMap<String,Boolean> mapped = new HashMap();
        String[] arr = s.split(" ");
        
               if(pattern.length() != arr.length)return false;

        
        for(int i = 0 ; i < pattern.length() ; i++){
            char ch = pattern.charAt(i);
            if(hm.containsKey(ch) == false){
                if(mapped.containsKey(arr[i]) == true){
                    return false;
                }else{
                    hm.put(ch,arr[i]);
                    mapped.put(arr[i],true);
                }
            }else{
                String mwith = hm.get(ch);
                if(mwith.equals(arr[i]) == false){
                    return false;
                }
            }
        }
        return true;
    }
}