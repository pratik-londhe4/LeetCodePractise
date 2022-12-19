class Solution {
    public int numRabbits(int[] answers) {
       HashMap<Integer,Integer> hm = new HashMap();
        
        for(int i = 0 ; i< answers.length ; i++){
            hm.put(answers[i] , hm.getOrDefault(answers[i] , 0)+1);
        }
        int minimum = 0;
        
        for(int i : hm.keySet()){
            minimum+=closest(i+1 , hm.get(i));
        }
        return minimum;
        
    }
    
    public int closest(int key , int value){
        while(value%key != 0){
            value++;
        }
        
        return value;
    }
}