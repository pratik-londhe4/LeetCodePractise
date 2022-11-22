/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size1 = getSize(headA);
        int size2 = getSize(headB);
        ListNode p1 = headA;
        ListNode p2 = headB;
        if(size1 > size2){  
              p1 =   shift(p1,(size1-size2));
            }
        else{
           p2 =  shift(p2 , (size2-size1));
        }
    
    while(p1 != null && p2 != null){
        if(p1 == p2)return p1;
        p1 = p1.next;
        p2  = p2.next;
    }
    
    return null;
    }
    
    public ListNode shift(ListNode node , int size){
        while(size > 0 && node != null){
            node = node.next;
            size--;
        }
        
        return node;
    }
    

    
    public int getSize(ListNode head){
        int size = 0;
        
        while(head != null){
            size++;
            head = head.next;
        }
        
        return size;
    }
}