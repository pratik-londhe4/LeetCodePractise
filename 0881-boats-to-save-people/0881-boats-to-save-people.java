class Solution {
    public int numRescueBoats(int[] people, int limit) {
      // sort the array
        Arrays.sort(people); // nlongn
        
        int left = 0;
        int right = people.length -1;
        
        int boats = 0;
        
        while(left <= right){
            // add the heaviest person to the boat;
            boats++;
            int remain = limit - people[right];
            right--;
            
            // second person can be added
            if(left <= right && people[left] <= remain){
                left++;
            }
        }
        
        return boats;
              
    }
}