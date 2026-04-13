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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if(head == null) return null;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        ListNode curr = new ListNode(0);
        ListNode dummy = curr;
        while(head!=null){
            int data = head.val;
            if(!set.contains(data)) {
                ListNode newNode = new ListNode(data);
                dummy.next = newNode;
                // head = head.next;
                dummy = dummy.next;
            }
            head = head.next;
        }
        return curr.next;
    }
}