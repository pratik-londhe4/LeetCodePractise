class Solution {
    public int maximalRectangle(char[][] matrix) {
        // calculate histograms and return the maxes
        int[] histo = new int[matrix[0].length];
        int res = 0;
        
        for(int i = 0 ; i < matrix[0].length ; i++){
           histo[i] = matrix[0][i]-'0';
            System.out.print(histo[i] + ",");
        }
        System.out.println();
               res = Math.max(res, largestRectangleArea(histo));

        for(int i = 1 ; i < matrix.length ; i++){
            for(int j = 0 ; j <matrix[0].length ; j++){
                if(matrix[i][j] > '0'){
                    histo[j] = histo[j] + matrix[i][j];
                    histo[j]-='0';
                    //System.out.println(true);
                    
                }else{
                    histo[j] = 0;
                }
                System.out.print( histo[j] + ",");
            }
            System.out.println();
            res = Math.max(res, largestRectangleArea(histo));
        }
        
        return res;
    }
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