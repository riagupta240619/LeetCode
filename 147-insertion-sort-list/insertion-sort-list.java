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
    public ListNode insertionSortList(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode h1 = head;
        while(h1!=null){
            arr.add(h1.val);
            h1 = h1.next;
        }
        Collections.sort(arr);
        for(int i = 0;i<arr.size();i++){
            ListNode newNode = new ListNode(arr.get(i));
            curr.next = newNode;
            curr = curr.next;
        }
        return dummy.next;
    }
}