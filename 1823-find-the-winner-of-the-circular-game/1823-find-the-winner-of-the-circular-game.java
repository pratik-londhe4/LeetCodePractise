class Solution {
    public int findTheWinner(int n, int k) {
        return helper(n,k) + 1;
    }
    
    public int helper(int n, int k){
        if(n == 0){
            return 1;
        }
        
        return (helper(n-1,k) + k ) % n;
    }
}