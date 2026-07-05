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
        if (head == null || head.next == null) {
            return;
        }

        // prisha note: finding the middle of the list
        ListNode slow = head; 
        ListNode fast = head; 

        while (fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 
        }

        // prisha note: reverse the second half
        ListNode second = slow.next; 
        slow.next = null; 

        ListNode prev = null; 
        while (second != null) {
            ListNode next = second.next; 
            second.next = prev; 
            prev = second; 
            second = next; 
        }

        // prisha note: merge the two halves
        ListNode first = head; 
        second = prev; 

        while (second != null) {
            ListNode temp1 = first.next; 
            ListNode temp2 = second.next; 

            first.next = second; 
            second.next = temp1; 

            first = temp1; 
            second = temp2;
        }
    }
}
