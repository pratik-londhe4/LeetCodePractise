class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> map = new HashMap();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0 ; i < nums2.length;){
            if(stack.isEmpty() || nums2[i] <= stack.peek()){
                stack.push(nums2[i]);
                i++;
            }else{
                map.put(stack.pop() , nums2[i]);
            }
        }
        
        // while(!stack.isEmpty()){
        //     map.put(stack.pop(),-1);
        // }
        
       for(int i = 0 ; i < nums1.length ; i++){
           nums1[i] = map.getOrDefault(nums1[i],-1);
       }
        return nums1;
    }
}