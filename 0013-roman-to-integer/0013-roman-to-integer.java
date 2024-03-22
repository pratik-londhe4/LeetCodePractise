class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int number = 0;
        int length = s.length();
        
        for(int i = 0 ; i < length; i++){
            char first = s.charAt(i);
            if(i+1 < s.length() && map.get(first) < map.get(s.charAt(i+1))){
                number-=map.get(first);
            }
              else{
                   number+=map.get(first);
              }
            
           
        }
        
        return number;
    }
}