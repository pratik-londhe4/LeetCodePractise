class Solution {
    public void moveZeroes(int[] arr) {
        int right = 0;
        int left = 0;
        
        while(right < arr.length){
            if(arr[right] != 0){
                swap(arr,left,right);
                left++;
                right++;
            }else{
                right++;
            }
        }
      
        }
    
        
        public void swap(int[]arr, int i , int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
       
    }
    
 

    
    
