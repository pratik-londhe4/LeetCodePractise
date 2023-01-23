class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        
        Stack<Integer> stack = new Stack();
        int ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            while(stack.size() > 0 && arr[i] > arr[stack.peek()]){
                int r = i;
                int cVal = arr[stack.pop()];
                
                if(stack.size() == 0){
                    break;
                }
                
                int l = stack.peek();
                
                int width = r-l-1;
                int maxHeight = Math.min(arr[l],arr[r]);
                int waterHeight = maxHeight - cVal;
                int water = width * waterHeight;
                
                ans+=water;
            }
            stack.push(i);
        }
        return ans;
    }
}