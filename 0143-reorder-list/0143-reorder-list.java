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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        // let's reverse the second half of the list
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
            
        }
        prev.next = null;
        //prev is new head for the rverse list
        prev = null;
        ListNode curr = slow;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
//         while(head != null){
//             System.out.println(head.val);
//             head = head.next;
//         }
        
        // now do the insertion
        ListNode merged = head;
        while(merged != null){
            ListNode temp = merged.next;
            ListNode temp2 = prev.next;
            merged.next = prev;
            if(temp == null){
                break;
            }
            prev.next = temp;
            
            merged = temp;
            prev = temp2;
        }
        
    }
}