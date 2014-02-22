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
    public ListNode insertionSortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = head;
        while (cur != null) {
            ListNode last = null;
            ListNode temp = cur.next;
            while (temp != null) {
                if (temp.val < cur.val)
                    last = temp;
                temp = temp.next;
            }
            if (last != null) {
                pre.next = cur.next;
                cur.next = last.next;
                last.next = cur;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}