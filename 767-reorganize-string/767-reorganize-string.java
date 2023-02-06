class Solution {
    public String reorganizeString(String s) {
        
        int n = s.length();
        
        
        //create map for character and frequncy;
        int[] hm = new int[256];
        
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            hm[(int)c]++;
        }
        
        //create priority queue or characters;
        Comparator<Character> comp = (c1,c2)->{         
                return hm[(int)c2] - hm[(int)c1];            
        };
        Queue<Character> q = new PriorityQueue(comp);
        
        //add mapped characters to queue;
        for(int i = 0 ; i < 256 ; i++){
            if(hm[i] > 0){
                q.add((char)i);
            }
            
        }
        
        //reorganize
        String ans = "";
        
        //base case
        char blocked = q.remove();
        ans+=blocked;
        hm[blocked]--;
        
        
        while(q.size() > 0){
            char temp = q.remove();
            
            if(hm[blocked] > 0){
            q.add(blocked);    
            }
            
            blocked = temp;
            ans+=blocked;
            hm[blocked]--;            
        }
        
        
        if(q.size() == 0 && hm[blocked] > 0){
            return "";
        }
        
        
        
        
        
        return ans;
        
    }
}