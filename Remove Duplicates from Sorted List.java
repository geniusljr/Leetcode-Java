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
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode temp = head;
        while (temp != null) {
            if (temp.next != null && temp.val == temp.next.val)
                temp.next = temp.next.next;
            else temp = temp.next;
        }
        
        return head;
    }
}