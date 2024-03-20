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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // get before node a
        ListNode before_a = list1;
        for(int i = 0 ; i < a -1  ; i++){
            before_a = before_a.next;
        }
        // get b node
        ListNode node_b = before_a;
        for(int i = 0 ; i <= b-a ; i++){
            node_b = node_b.next;
        }
        //get tail of second list
        ListNode tail_list2 = list2;
        while(tail_list2.next != null){
            tail_list2 = tail_list2.next;
        }
        
        // add the list 2 
        before_a.next = list2;
        tail_list2.next = node_b.next;
        
        return list1;
        
        
    }
}