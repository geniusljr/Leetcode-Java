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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || n == 0)
            return head;
        ListNode temp = head;
        ListNode tail = head;
        int total = 1;
        while (tail.next != null) {
            tail = tail.next;
            total++;
        }
        n %= total;
        
        int count = 0;
        while (count++ < total-n-1) {
            temp = temp.next == null ? head : temp.next;
        }
        
        tail.next = head;
        head = temp.next;
        temp.next = null;
        return head;
        
    }
}