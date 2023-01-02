class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int total = 0;
        for(int i = 1 ; i < salary.length-1 ; i++){
            total+=salary[i];
        }
        
       return   total/(salary.length-2d);
       
    }
}