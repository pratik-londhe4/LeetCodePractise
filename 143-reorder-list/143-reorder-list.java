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
        ListNode mid = middleNode(head);
       ListNode head2 = mid.next;
        mid.next = null;
        
        head2 = reverseList(head2);
        
       head =  merge(head,head2);
    }
    
    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode nextofCurr = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = nextofCurr;
            
        }
        
        return prev;
    }
    
    public ListNode merge(ListNode head1 , ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode curr = dummy;
        
        while(p1 != null && p2 != null){
            ListNode nextofP1 = p1.next;
            p1.next = null;
            
            ListNode nextofP2 = p2.next;
            p2.next = null;
            
            curr.next = p1;
            p1 = nextofP1;
            curr = curr.next;
            
            curr.next = p2;
            p2 = nextofP2;
            curr = curr.next;
        }
        
        curr.next = p1;
        
        return dummy.next;
        
    }
}