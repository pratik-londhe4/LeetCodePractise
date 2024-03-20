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
        // find node before a
        ListNode before_a = list1;
        for(int i = 0 ; i < a -1 ; i++){
            before_a = before_a.next;
        }
        // find node b
        ListNode node_b = before_a;
        for(int i = 0 ; i < b-a+1 ; i++){
            node_b = node_b.next;
        }
        //find tail of list2
        ListNode tail_list2 = list2;
        while(tail_list2.next != null){
            tail_list2 = tail_list2.next;
        }
        
        before_a.next = list2;
        tail_list2.next = node_b.next;
        
        return list1;
    }
}