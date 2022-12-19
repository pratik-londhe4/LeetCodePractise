class Solution {
    public int numRabbits(int[] answers) {
      int[] freq = new int[1001];
        
        for(int i : answers){
            freq[i]++;
        }
        
        int minimum = 0;
        for(int i = 0 ; i < freq.length ; i++){
            minimum+=closest(i+1 , freq[i]);
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