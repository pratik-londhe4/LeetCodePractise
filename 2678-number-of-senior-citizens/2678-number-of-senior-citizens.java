class Solution {
    public int countSeniors(String[] details) {
        int seniors = 0;
        for(String passenger : details){
            if(getAge(passenger) > 60){
                seniors++;
            }
        }
        
        return seniors;
    }
    
    
    public int getAge(String passenger){
        
        int age = Integer.parseInt(passenger.substring(11,13));
        
        return age;
    }
}