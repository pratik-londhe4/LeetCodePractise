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
        
        //find mid of the list
        ListNode mid = middleNode(head);
        
        //break a new linked list from mid
        ListNode head2 = mid.next;
        mid.next = null;
        
        //reverse the half linked list
       head2 = reverseList(head2);
        
        //merge both linked lists
        
        head = merge(head,head2);
        
        
    }
    
    public ListNode merge(ListNode head1 ,ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode curr = dummy;
        
        while(p1 != null && p2 != null){
            ListNode nextofP1 = p1.next;
            p1.next = null;
            
            ListNode nextofP2 = p2.next;
            p2.next = null;
            
            //merge p1
            curr.next = p1;
            p1 = nextofP1;
            curr = curr.next;
            
            //merge p2
            curr.next = p2;
            p2 = nextofP2;
            curr = curr.next;
        }
        
        curr.next = p1;
        
        return dummy.next;
    }
    
    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
        ListNode nextOfCurr = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nextOfCurr;
        }
        
        return prev;
        
    }
}