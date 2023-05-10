class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //get low and high and calculate mid
        //while low < high run loop
        //inside loop check how many elements are smaller than or equal to mid
        //store the count, if count is >= k then try to reduce the state space by doing low = mid+1
        //if count is less than k then increase high = mid+1
        //return low at the end
        
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(countLessOrEqual(matrix,mid) < k){
                low = mid+1;
            }else{
                high = mid - 1;
            }
            
        }
        return low;
        
    }
    
    int countLessOrEqual(int [][] matrix , int val){
        int count = 0 , i = matrix.length-1 , j = 0;
        
        while(i >= 0 && j < matrix.length){
            if(matrix[i][j] > val)i--;
            else{
                count = count + i + 1;
                j++;
            }
        }
        return count;
    }
}