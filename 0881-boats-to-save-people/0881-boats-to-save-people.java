class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int left= 0 , right = people.length-1;
        int boats = 0;
        
        while(left <= right){
            // add the heviest person first
            int remaining = limit - people[right];
            boats++;
            right--;
            
            // check if one more perosn can be added
            if(people[left] <= remaining){
                left++;
            }
        }
        return boats;
    }
}