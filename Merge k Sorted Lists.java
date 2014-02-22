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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (lists == null || lists.size() == 0)
            return null;
        Comparator<ListNode> comparator = new Comparator<ListNode> () {
            public int compare(ListNode node1, ListNode node2) {
                if (node1.val < node2.val)
                    return -1;
                if (node1.val > node2.val)
                    return 1;
                return 0;
            }
        };
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.size(), comparator);
        
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null)
                minHeap.add(lists.get(i));
        }
        
        ListNode head = null;
        ListNode cur = null;
        while (!minHeap.isEmpty()) {
            if (head == null) {
                head = minHeap.poll();
                cur = head;
            }
            else {
                cur.next = minHeap.poll();
                cur = cur.next;
            }
            if (cur.next != null)
                minHeap.add(cur.next);
        }
        
        return head;
    }
}