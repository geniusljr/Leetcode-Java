/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null)
            return;
        Queue<TreeLinkNode> queue1 = new LinkedList<TreeLinkNode>();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            Queue<TreeLinkNode> queue2 = new LinkedList<TreeLinkNode>();
            while (!queue1.isEmpty()) {
                TreeLinkNode cur = queue1.poll();
                cur.next = queue1.peek();
                if (cur.left != null) {
                    queue2.add(cur.left);
                    queue2.add(cur.right);
                }
            }
            queue1 = queue2;
        }
    }
}