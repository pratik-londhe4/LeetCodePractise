class Solution {
    public boolean isPalindrome(int x) {
        int i = x;
        int number = 0;
        
        while(i >0){
            number = number*10+i%10;
            i/=10;
        }
        return x == number;
    }
}