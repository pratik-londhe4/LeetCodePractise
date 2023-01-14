class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nsl = nextSmallerLeft(heights , heights.length);
        int[] nsr = nextSmallerRight(heights , heights.length);
        // System.out.println(Arrays.toString(nsl));
        // System.out.println(Arrays.toString(nsr));
        
        int max = 0;
        for(int i = 0 ; i < heights.length ; i++){
            max = Math.max(max , heights[i] * (nsr[i]-nsl[i]-1));
        }
        
        return max;
    }
    
    int[] nextSmallerLeft(int[] arr , int n){
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack();
        
        for(int i = n-1 ; i>= 0; i--){
            while(stack.size() >0 && arr[i] < arr[stack.peek()]){
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        
        while(stack.size() >0){
            ans[stack.pop()] = -1;
        }
        
        return ans;
    }
    
    
     int[] nextSmallerRight(int[] arr , int n){
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i < n; i++){
            while(stack.size() >0 && arr[i] < arr[stack.peek()]){
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        
        while(stack.size() >0){
            ans[stack.pop()] = n;
        }
        
        return ans;
    }
    
    
}