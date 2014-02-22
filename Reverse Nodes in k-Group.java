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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null || k == 1)
            return head;
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead;
        int count = 0;
        while (head != null) {
            count++;
            if (count % k == 0) {
                pre = reverse(pre, head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return preHead.next;
    }
    
    public ListNode reverse(ListNode pre, ListNode next) {
        ListNode last = pre.next, cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
}