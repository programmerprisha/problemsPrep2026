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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // note: if the lists were not reverse like hundreds place was in first node then we would have to reverse the lists or use stacks or recurse to reach the end first
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy; 
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; 

            if (l1 != null) {
                sum+= l1.val; 
                l1 = l1.next; 
            }

            if (l2 != null) {
                sum += l2.val; 
                l2 = l2.next; 
            }

            carry = sum/10; 
            curr.next = new ListNode(sum % 10);
            curr = curr.next; 
        }

        return dummy.next;
    }
}