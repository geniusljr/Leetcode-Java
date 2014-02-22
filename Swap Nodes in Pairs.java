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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode node = head;
        boolean odd = true;
        ListNode last = null;
        ListNode newH = null;
        while (node != null) {
            ListNode oriNext = node.next;
            if (odd) {
                if (node.next == null)
                    node.next = null;
                else if (node.next.next == null)
                    node.next = null;
                else if (node.next.next.next == null)
                    node.next = node.next.next;
                else if (node.next.next.next != null)
                    node.next = node.next.next.next;
                last = node;
                odd = false;
            }
            else {
                node.next = last;
                if (newH == null)
                    newH = node;
                odd = true;
            }
            node = oriNext;
        }
        return newH;
        
    }
}