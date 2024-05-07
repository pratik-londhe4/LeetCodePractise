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
    public ListNode doubleIt(ListNode head) {
        head = reverseList(head);
        ListNode curr = head;
        int carry = 0;
        
        while(curr != null){
            
            int sum = 2 * curr.val + carry;
            carry = sum/10;
            curr.val = sum%10;
            
            curr = curr.next;
            
        }
        
        head = reverseList(head);
        
        if(carry > 0){
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }
        
        return head;
        
        
    }
    
    public ListNode reverseList(ListNode head){
        
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            
        }
        
        return prev;
    }
}