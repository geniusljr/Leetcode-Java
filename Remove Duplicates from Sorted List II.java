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
    public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null)
            return head;
        ListNode newH = new ListNode(0);
        newH.next = head;
        ListNode tempH = newH;
        ListNode lastNode = head;
        ListNode cur = lastNode.next;
        boolean lastDup = false;
        while (cur != null) {
            if (cur.val == lastNode.val) {
                lastDup = true;
            }
            else {
                if (!lastDup) {
                    tempH.next = lastNode;
                    tempH = tempH.next;
                }
                lastNode = cur;
                lastDup = false;
            }
            cur = cur.next;
        }
        tempH.next = lastDup ? null : lastNode;
        
        return newH.next;
    }
}
