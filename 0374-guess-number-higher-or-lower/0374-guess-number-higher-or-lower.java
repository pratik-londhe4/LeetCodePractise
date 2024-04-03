/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(guess(n) == 0){
            return n;
        }
        int low = 1;
        int high = n;
        int ans = low + ((high - low) / 2);
        
        while(guess(ans) != 0){
            // guess high, check on lower side
             ans = low + ((high - low) / 2);
            if(guess(ans) == -1){
                high = ans-1;
            }else if(guess(ans) == 1)
            // guessed too low, check on higher side.
            {
                low = ans+1;
                
                }else if(guess(ans) == 0){
                return ans;
            }
        }
        return ans;
    }
}