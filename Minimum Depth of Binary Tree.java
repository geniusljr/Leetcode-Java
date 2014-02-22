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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null)
        	return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        int depth = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
        	while (!queue.isEmpty()) {
        		TreeNode temp = queue.poll();
        		if (temp.left == null && temp.right == null)
        			return depth;
        		if (temp.left != null)
        			queue2.offer(temp.left);
        		if (temp.right != null)
        			queue2.offer(temp.right);
        	}
        	queue = queue2;
        	queue2 = new LinkedList<TreeNode>();
        	depth++;
        }
        return depth;
    }
}