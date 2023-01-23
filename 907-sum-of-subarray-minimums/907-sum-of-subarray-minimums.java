class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        Stack<Integer> stack = new Stack();
        int sum = 0;
        int mod = 1000000007;
        for(int i = 0 ; i < arr.length ; i++){
            
            while(stack.size() > 0 && arr[i] < arr[stack.peek()]){
                int c = stack.pop();
                int r = i;
                int l = -1;
                if(stack.size() != 0){
                    l = stack.peek();
                }
                
                  long numOfSubarr = ((c - l) * (r - c)) % mod;
                sum+= (numOfSubarr * arr[c]) % mod;
                sum%=mod;
            }
            stack.push(i);
        }
        
        while(stack.size() > 0){
            int c = stack.pop();
            int r = arr.length;
            int l = -1;
            if(stack.size() > 0){
                l = stack.peek();
            }
            
             long numOfSubarr = ((c - l) * (r - c)) % mod;
                sum+= (numOfSubarr * arr[c]) % mod;
            sum%=mod;
        }
        
        return sum % mod;
        
    }
}