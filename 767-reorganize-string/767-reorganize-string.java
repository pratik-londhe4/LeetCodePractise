class Solution {
    public String reorganizeString(String s) {
        
        
        //create map for character and frequncy;
        HashMap<Character,Integer> hm = new HashMap();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        
        //create priority queue or characters;
        Comparator<Character> comp = (c1,c2)->{         
                return hm.get(c2) - hm.get(c1);            
        };
        Queue<Character> q = new PriorityQueue(comp);
        
        //add mapped characters to queue;
        for(char c : hm.keySet()){
            q.add(c);
        }
        
        //reorganize
        String ans = "";
        
        //base case
        char blocked = q.remove();
        ans+=blocked;
        hm.put(blocked,hm.get(blocked)-1);
        
        
        while(q.size() > 0){
            char temp = q.remove();
            
            if(hm.get(blocked) > 0){
            q.add(blocked);    
            }
            
            blocked = temp;
            ans+=blocked;
            hm.put(blocked,hm.get(blocked)-1);            
        }
        
        
        if(q.size() == 0 && hm.get(blocked) > 0){
            return "";
        }
        
        
        
        
        
        return ans;
        
    }
}