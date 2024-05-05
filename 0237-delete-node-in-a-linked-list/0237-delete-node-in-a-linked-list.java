/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // we don't get head
        //swap the damn nodes 
        ListNode curr = node;
        ListNode prev = curr;
        while(curr.next != null){
            int temp = curr.val;
            curr.val = curr.next.val;
            curr.next.val = temp;
             prev = curr;
            curr = curr.next;
           
        }
        
        prev.next = null;
    }
}