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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode newH = new ListNode(0);
        newH.next = head;
        ListNode insertPoint = newH;
        while (insertPoint.next != null && insertPoint.next.val < x) {
            insertPoint = insertPoint.next;
        }
        ListNode insertNode = insertPoint.next;
        while (insertNode != null && insertNode.next != null) {
            if (insertNode.next.val < x) {
                ListNode temp = insertNode.next;
                insertNode.next = temp.next;
                temp.next = insertPoint.next;
                insertPoint.next = temp;
                insertPoint = insertPoint.next;
            } else {
                insertNode = insertNode.next;
            }
        }
        return newH.next;
    }
}