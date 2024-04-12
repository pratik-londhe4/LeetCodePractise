class Solution {
    public int trap(int[] height) {
        // naive o(n) TC SC solution
        int maxLeft[] = new int[height.length];
        int maxRight[] = new int[height.length];
        
        
        // let's calcualte maxLEft and maxRight for ith index
        int max = 0;
        for(int i = 0 ; i < maxLeft.length ; i++){
            if(height[i] < max){
                maxLeft[i] = max;
            }else {
                // >= max , set the height first and then increment
                maxLeft[i] = max;
                max = height[i];
            }
        }
        
        // lets do same but in reverse for right
        max = 0;
        for(int i = maxRight.length -1 ; i >= 0 ; i--){
            maxRight[i] = max;
            if(height[i] > max){
                max = height[i];
            }
        }
        
        // now ley's get min(l-r) of our equation, lets do this more complexily
        
        int ans = 0;
        for(int i = 0 ; i < height.length ; i++){
            int waterUnits = Math.min(maxLeft[i], maxRight[i]) - height[i];
            waterUnits = waterUnits < 0 ? 0 : waterUnits;
            ans+=waterUnits;
        }
        
        return ans;
    }
}