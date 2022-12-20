class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
         String ans = "";
        for(int i = 0 ; i < arr.length ; i++){
                     
            ans+=rev(arr[i].toCharArray());
              if(i!= (arr.length-1)){
                ans+=" ";
            }
        }
       
        return ans;
    }
    
    public String rev(char[] s){
        String ans = "";
        int n = s.length;
        for(int i = n-1; i >= 0 ; i--){
            ans = ans + s[i];
        }
        
        return ans;
    }
}