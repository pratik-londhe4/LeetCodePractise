class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] leftLimit = getLeftLimit(heights);
        int[] rightLimit = getRightLimit(heights);
        
        int max = 0;
        for(int i = 0; i < heights.length ; i++){
            int width = rightLimit[i]-leftLimit[i]+1;
            max = Math.max(max, width * heights[i]);
        }
        return max;
    }
    
    public int[] getLeftLimit(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int left[] = new int[heights.length];
        
        for(int i = 0 ; i < heights.length ; i++){
            if(stack.isEmpty()){
                left[i] = 0;
                stack.push(i);
            }else {
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? 0 : stack.peek()+1;
                stack.push(i);
            }
        }
        return left;
    }
    
     public int[] getRightLimit(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int right[] = new int[heights.length];
        
        for(int i = heights.length-1 ; i >= 0 ; i--){
            if(stack.isEmpty()){
                right[i] = heights.length-1;
                stack.push(i);
            }else {
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? heights.length-1 : stack.peek()-1;
                stack.push(i);
            }
        }
        return right;
    }
}