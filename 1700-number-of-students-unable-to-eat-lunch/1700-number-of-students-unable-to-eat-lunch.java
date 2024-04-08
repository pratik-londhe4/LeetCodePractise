class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count0 = 0;
        int count1 = 0;
        int res = students.length;
        
        // count the students
        for(int i = 0 ; i < students.length ; i++){
            if(students[i] == 0){
                count0++;
            }else{
                count1++;
            }
        }
        
        for(int i = 0 ; i < sandwiches.length ; i++){
            if(sandwiches[i] == 0 && count0 > 0){
                count0--;
                res--;
            }else if(sandwiches[i] == 1 && count1 > 0){
                count1--;
                res--;
            }else {
                return res;
            }
        }
        return res;
    }
}