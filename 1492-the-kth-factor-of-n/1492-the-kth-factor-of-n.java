class Solution {
    public int kthFactor(int n, int k) {
        int[] factors = new int[n];
        int count = 0;
        for(int i = 1 ; i <= n ; i++){
            if( n % i == 0 ){
                factors[count] = i;
                count++;
            }
        }
        if( k > count){
            return -1;
        }
        return factors[k-1];
    }
}