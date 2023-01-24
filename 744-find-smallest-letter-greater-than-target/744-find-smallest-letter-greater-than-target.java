class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int lo = 0;
        int hi = n;
        
        if(target >= letters[n-1]){
            return letters[0];
        };
        
        char potential = 'z';
        
        while(lo <= hi){
            int mid = (lo+hi)/2;
            
            if(letters[mid] > target){
                potential = (char)Math.min(letters[mid],potential);
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        
        return potential;
    }
}