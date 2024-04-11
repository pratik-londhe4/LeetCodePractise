class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack  = new Stack<>();
        stack.push(num.charAt(0));
        
        // stack should always be in non-decreasing order
        for(int i = 1 ; i < num.length() ; i++){
            char curr = num.charAt(i);
            while(k > 0 && !stack.isEmpty() &&  stack.peek() > curr){
                stack.pop();
                k--;
            }
            stack.push(curr);
        }
        
        while(k > 0){
            stack.pop();
            k--;
        }
        
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        
        res.reverse();
               int i = 0;

        while(i < res.length() && res.charAt(i) <= '0'){
             i++;
        }
        
        res.delete(0,i);
        if(res.length() == 0){
            return "0";
        }
        return res.toString();
    }
}