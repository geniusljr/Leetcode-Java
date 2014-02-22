/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode s1 = head;
        ListNode s2 = head;
        while (s1 != null && s2 != null) {
            if (s1.next == null || s2.next == null)
                return null;
            if (s2.next == s1) {
                s1 = s1.next;
                s2 = head;
                while (s1 != s2) {
                    s1 = s1.next;
                    s2 = s2.next;
                }
                return s1;
            }
            s1 = s1.next;
            s2 = s2.next.next;
        }
        return null;
    }
}