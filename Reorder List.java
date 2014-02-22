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
    public void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null)
            return;
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        int index = 0;
        ListNode mid = head;
        while (index < count/2) {
            mid = mid.next;
            index++;
        }
        
        ListNode tail = mid.next;
        ListNode front = mid;
        while (tail != null) {
            temp = tail.next;
            tail.next = front;
            front = tail;
            tail = temp;
        }
        tail = front;
        mid.next = null;
        
        ListNode start = head;
        while (tail != mid) {
            ListNode nextStart = start.next;
            ListNode nextTail = tail.next;
            start.next = tail;
            tail.next = nextStart;
            tail = nextTail;
            start = nextStart;
        }
        return;
    }
}