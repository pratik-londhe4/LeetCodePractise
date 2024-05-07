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
            curr.val = sum%10;
            carry = sum/10;
            curr = curr.next;
        }
         // what if carry is not zero
        System.out.println(carry);
        
        head =  reverseList(head);
        if(carry > 0){
            // prepend a node with val as carry
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
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        
        return prev;
    }
}