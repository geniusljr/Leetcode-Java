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
        if (head == null || head.next == null)
            return head;
            
        ListNode node = head;
        ListNode last = null;
        ListNode newH = null;
        while (node != null) {
            ListNode next = node.next;
            if (next != null) {
                if (last == null)
                    newH = next;
                else
                    last.next = next;
                
                node.next = next.next;
                last = node;
                next.next = node;
            }
            node = node.next;
        }
        return newH;
        
    }
}