/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null || l2 != null) {
            int l1V = l1 != null ? l1.val : Integer.MAX_VALUE;
            int l2V = l2 != null ? l2.val : Integer.MAX_VALUE;
            temp.next = new ListNode(l1V < l2V ? l1V : l2V);
            if (l1V < l2V)
                l1 = l1 == null ? null : l1.next;
            else l2 = l2 == null ? null : l2.next;
            temp = temp.next;
        }
        return head.next;
    }
}