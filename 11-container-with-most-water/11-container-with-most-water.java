class Solution {
    public int maxArea(int[] height) {
        int i=  0 ; 
        int j = height.length-1;
        int area = 0;
        
        while(i < j){
            int h = Math.min(height[i],height[j]);
            int w = j-i;
            if(h*w > area)area = h*w;
            
            if(height[i] < height[j]){
                i++;
            }else{
              
                    j--;
                }
            }
            
    
        return area;
    }
}