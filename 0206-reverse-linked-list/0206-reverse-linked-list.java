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
    public ListNode reverseList(ListNode head) {
        // let's use 2 pointers
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            // store the next next
            ListNode next = curr.next;
            //reverse the link
            curr.next = prev;
            //update pointers
            prev = curr;
            curr = next;
        }
        return prev;
    }
}