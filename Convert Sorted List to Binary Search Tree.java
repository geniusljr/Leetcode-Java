/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        int count = 0;
        temp = head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        while (count < length/2) {
            pre = temp;
            temp = temp.next;
            count++;
        }
        TreeNode root = new TreeNode(temp.val);
        pre.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(temp.next);
        return root;
    }
}