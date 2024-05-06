/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
       
        // Reverse the list
        ListNode reverse = reverseList(head);
        
        Stack<Integer> stack = new Stack<>();
        int max = -1;
        // Push the max to stack
        while(reverse != null){
            if(reverse.val >= max){
                max = reverse.val;
                stack.push(reverse.val);
            }
            reverse = reverse.next;
        }
        
        // Create new list
        head = new ListNode(stack.pop());
        ListNode prev = head;
        while(!stack.isEmpty()){
            prev.next = new ListNode(stack.pop());
            prev = prev.next;
        }
        
        return head;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            
            //update the pointers
            prev = curr;
            curr = next;
            
            
        }
        
        return prev;
    }
    
}