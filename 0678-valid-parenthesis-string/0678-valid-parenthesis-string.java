class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;
        
        char arr[] = s.toCharArray();
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == '('){
                leftMin++;
                leftMax++;
            }else if(arr[i] == ')'){
                leftMin--;
                leftMax--;
            }else {
                leftMin--;
                leftMax++;
            }
            
            if(leftMin < 0){
                leftMin = 0;
            }
            
            if(leftMax < 0){
                return false;
            }
        }
        
        return leftMin == 0;
            
    }
}