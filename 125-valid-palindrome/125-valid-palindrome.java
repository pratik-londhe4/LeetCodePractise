import java.util.*;
class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        Vector<Character> arr = new Vector<>();

		for(int i = 0 ; i < str.length() ; i++){
			if(isAlpha(str.charAt(i))){
				arr.add(str.charAt(i));
			}
		}

		int i = 0 ;
		int j = arr.size()-1;

		while(i <= j){
			if(arr.get(i) != arr.get(j)){
				
				return false;
			}
			i++;
			j--;
		}
return true;
		
	}

	public static boolean isAlpha(char c){
		if((c > 47 && c < 58) || (c > 96 && c < 123)){
			return true;
		}
		return false;
	}

      
        
    }
