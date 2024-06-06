class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        // populate map
        for(int i = 0 ; i < hand.length ;   i++){
            int curr = map.getOrDefault(hand[i],0);
            map.put(hand[i], curr+1);
           
        }
        
        for(Integer key : map.keySet()){
            q.add(key);
        }
        
       
        
      while(!q.isEmpty()){
          int curr = q.peek();
          int freq = map.get(curr);
          for(int i = 0 ; i < groupSize ; i++){
              int next = map.getOrDefault(curr+i,0);

              if(next == 0){
                  return false;
              }
              
              map.put(curr+i,next-1);
              if(next == 1){
                  q.poll();
              }
          }
      }
        
        return true;
    }
    
    
}

