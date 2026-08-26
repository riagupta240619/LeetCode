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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode oddHead = new ListNode(0);;
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode(0);;
        ListNode evenTail = evenHead;
        ListNode temp = head;
        int pos = 1;
        while(temp!=null){
            if(pos%2!=0){
                ListNode newNode = new ListNode(temp.val);
                oddTail.next = newNode;
                oddTail = oddTail.next;
            }else{
                ListNode newNode = new ListNode(temp.val);
                evenTail.next = newNode;
                evenTail = evenTail.next;
            }
            temp = temp.next;
            pos++;
        }
        oddTail.next = evenHead.next;
        return oddHead.next;
    }
}