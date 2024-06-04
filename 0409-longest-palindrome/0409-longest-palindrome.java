class Solution {
    public int longestPalindrome(String s) {
        int ans = 0;
        if(s.length() == 1){
            return 1;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            int curr = map.getOrDefault(s.charAt(i), 0);
            curr++;
            System.out.println(curr);
            if(curr > 0 && curr% 2 == 0){
                ans+=2;
            }
            map.put(s.charAt(i), curr);
        }
        
        for(int i = 0 ; i < s.length() ; i++){
            int curr = map.get(s.charAt(i));
            if(curr%2 != 0){
                ans++;
                break;
            }
            
        }
        
        return ans ;
    }
}