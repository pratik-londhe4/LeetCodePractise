class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] arr  = s.toCharArray();
        
        for(int i = 0 ; i < arr.length ; i++){
            if(stack.isEmpty() || arr[i] == '(' || arr[i] == '[' || arr[i] == '{'){
                stack.push(arr[i]);
            }else if((stack.peek() == '(' && arr[i] == ')') || 
                     (stack.peek() == '[' && arr[i] == ']') ||
                     (stack.peek() == '{' && arr[i] == '}')){
                stack.pop();
            }else{
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}