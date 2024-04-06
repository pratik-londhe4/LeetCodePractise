class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        StringBuilder ans = new StringBuilder();
        int count = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            char curr = s.charAt(i);
            
            if(curr == '('){
                stack.push(curr);
                count++;
            }else if(curr == ')' && count > 0){
                stack.push(curr);
                count--;
            }else if(curr != ')'){
                stack.push(curr);
            }
        }
        
        int i = 0;
        while(!stack.isEmpty()){
            char curr = stack.pop();
            if(curr == '(' && count > 0){
                count--;
            }else {
                ans.append(curr);
               
            }
        }
            
        return ans.reverse().toString();
            
            
            
        }
    }
