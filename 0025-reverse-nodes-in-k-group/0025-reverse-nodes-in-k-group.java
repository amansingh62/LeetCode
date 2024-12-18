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
    public ListNode reverseKGroup(ListNode head, int k) {
         if (head == null) return null;

        ListNode curr = head;
        int count = 0;

        while(curr != null && count < k){
            curr = curr.next;
            count++;
        }
        if(count == k){
            ListNode prev = null;
            curr = head;
            int tempk = k;
            while(tempk > 0){
                ListNode next = curr.next;
                         curr.next = prev;
                         prev = curr;
                         curr = next;
                         tempk--;
            }
            head.next = reverseKGroup(curr, k);
            return prev;
        }
        return head;
    }
}