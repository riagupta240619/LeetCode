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
    public ListNode partition(ListNode head, int x) {
        // List<Integer> arr = new ArrayList<>();
        // ListNode dummy = head;
        // while(dummy!=null){
        //     arr.add(dummy.val);
        //     dummy = dummy.next;
        // }
        // List<Integer> arr2 = new ArrayList<>();
        // for(int i = 0;i<arr.size();i++){
        //     if(arr.get(i) < x){
        //         arr2.add(arr.get(i));
        //     }
        // }
        // for(int i = 0;i<arr.size();i++){
        //     if(arr.get(i) >= x){
        //         arr2.add(arr.get(i));
        //     }
        // }
        // ListNode curr = new ListNode(0);
        // ListNode top = curr;
        // for(int i = 0;i<arr.size();i++){
        //     ListNode newNode = new ListNode(arr2.get(i));
        //     top.next = newNode;
        //     top = top.next;
        // }
        // return curr.next;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode h1 = head;
        while(h1!=null){
            if(h1.val < x){
                ListNode newNode = new ListNode(h1.val);
                curr.next = newNode;
                curr = curr.next;
            }
            h1 = h1.next;
        }
        h1 = head;
        while(h1!=null){
            if(h1.val >= x){
                ListNode newNode = new ListNode(h1.val);
                curr.next = newNode;
                curr = curr.next;
            }
            h1 = h1.next;
        }
        return dummy.next;
    }
}