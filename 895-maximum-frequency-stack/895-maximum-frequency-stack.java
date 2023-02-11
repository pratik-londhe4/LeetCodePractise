class FreqStack {
    //a hashmap of stacks that stored freq->vals pairs
    //we keep track of current max frequency
    //also a hashmap is required to keep track of frequencuy of each element;
    //then we can just pop the element at max frequency and decrement the max if the stack becomes empty
    
    HashMap<Integer,Integer> freq_map ;
    HashMap<Integer,Stack<Integer>> stack ;
    int max_freq = 0;

    public FreqStack() {
        freq_map = new HashMap();
        stack = new HashMap();
    }
    
    public void push(int val) {
        freq_map.put(val,freq_map.getOrDefault(val,0)+1);
        //get frequency of the pushed element after updating
        int curr_freq = freq_map.get(val);
        //if stack map contains the freq, push element else create new stack for the frequency
        if(stack.containsKey(curr_freq)){
            stack.get(curr_freq).push(val);
        }else{
            stack.put(curr_freq, new Stack());
            stack.get(curr_freq).push(val);            
        }
        
        //update max frequency
        max_freq = Math.max(curr_freq,max_freq);
    }
    
    public int pop() {
        int popped = stack.get(max_freq).pop();
        
        freq_map.put(popped,freq_map.get(popped)-1);
        if(stack.get(max_freq).isEmpty()){
            max_freq--;
        }
        
        return popped;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */