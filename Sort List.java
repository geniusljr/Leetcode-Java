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
    public ListNode sortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null || head.next == null)
            return head;
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int count = 0;
        temp = head;
        while (count < len/2-1) {
            temp = temp.next;
            count++;
        }
        ListNode first = head, second = temp.next;
        temp.next = null;
        first = sortList(first);
        second = sortList(second);
        
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        while (first != null || second != null) {
            int firstNum = first == null ? Integer.MAX_VALUE : first.val;
            int secondNum = second == null ? Integer.MAX_VALUE : second.val;
            if (firstNum < secondNum) {
                cur.next = new ListNode(firstNum);
                cur = cur.next;
                first = first.next;
            } else {
                cur.next = new ListNode(secondNum);
                cur = cur.next;
                second = second.next;
            }
        }
        return preHead.next;
    }
}