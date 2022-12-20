class Solution {
    public String reverseWords(String s) {
        char[]arr = new char[s.length()];
        
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = s.charAt(i);
        }
        
        int start = 0;
        int end = 0;
        for(int i = 0  ; i < arr.length ; i++){
            if(arr[i] == ' ' || i == arr.length-1){
                if(i == arr.length-1){
                    end = i;
                }else{
                                   end = i-1;        
 
                }
            while(start <= end){
                char temp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = temp;
            }           
                start = i+1;
            }          
        }
        
         start = end;
         end = arr.length-1;
        
        // while(start <= end){
        //      char temp = arr[start];
        //         arr[start++] = arr[end];
        //         arr[end--] = temp;
        // }
        
        
        return new String(arr);
    }
}