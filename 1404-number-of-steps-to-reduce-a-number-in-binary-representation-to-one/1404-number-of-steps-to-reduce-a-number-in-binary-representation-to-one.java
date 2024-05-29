class Solution {
    public int numSteps(String s) {
        int ans = 0 ;
        
        
        while(!s.equals("1") ){
            int i = s.length()-1;
            if(s.charAt(i)  == '0'){
                s = s.substring(0,i);
            }else {
                s = addOne(s);               
            }
            ans++;
           
        }
        
        return ans;
    }
    
    public String addOne(String s){
        char[] arr = s.toCharArray();
        
        int i = arr.length-1;
        while(i >= 0 && arr[i] == '1'){
             arr[i] = '0';
            i--;
           
        }
        
        if(i == -1){
           return "1" + new String(arr);
        }else{
            arr[i] = '1';
            return new String(arr);
        }
        
    
        
        
    }
}