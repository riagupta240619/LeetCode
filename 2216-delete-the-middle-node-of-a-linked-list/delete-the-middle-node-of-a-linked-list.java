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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        int c = 0;
        ListNode x = head;
        while(x!=null){
            c++;
            x = x.next;
        }
        int idx = c/2 - 1;
        ListNode curr = head;
        ListNode dummy = curr;
        while(idx-- >0){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy;
    }
}