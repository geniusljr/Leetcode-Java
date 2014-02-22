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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (m >= n || m <= 0)
            return head;
        int count = 1;
        ListNode revHead = new ListNode(0);
        ListNode tmpRevHead = revHead;
        tmpRevHead.next = head;
        while (count < m) {
        	tmpRevHead = tmpRevHead.next;
            count++;
        }
        ListNode cur = tmpRevHead.next;
        while (count < n) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = tmpRevHead.next;
            tmpRevHead.next = temp;
            count++;
        }
        return revHead.next;
    }
}