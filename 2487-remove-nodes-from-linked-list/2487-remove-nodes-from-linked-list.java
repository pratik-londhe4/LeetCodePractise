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
        ListNode reversed = reverseList(head);
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        ListNode reversedHead = reversed;
        ListNode prev = null;
        while(reversed != null){
            if(max > reversed.val){
                
            }
            else{
                max = reversed.val;
                stack.push(reversed.val);
            }
            prev = reversed;
            reversed = reversed.next;
        }
        
        head = new ListNode(stack.pop());
        prev = head;
        while(!stack.isEmpty()){
            prev.next = new ListNode(stack.pop());
            prev = prev.next;
        }
        return head;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            
            //update pointers
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
//     public ListNode deleteNode(ListNode head, int val){
//         ListNode curr = head;
//         // delete at start
//         if(head.val == val){
//             head = head.next;
//             return head;
//         }
//         //at the end or in middle
//         ListNode prev = head;
//         while(curr.next != null && curr.next.val != val ){
//             prev = curr;
//             curr = curr.next;
            
//         }
//         prev.next = curr.next;
//         return head;
//     }
    
}