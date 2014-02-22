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
        return getMinDepth(root, 1);
    }

    public int getMinDepth(TreeNode node, int depth) {
        if (node.left == null && node.right == null)
            return depth;
        int leftDepth = node.left == null ? Integer.MAX_VALUE : getMinDepth(node.left, depth+1);
        int rightDepth = node.right == null ? Integer.MAX_VALUE : getMinDepth(node.right, depth+1);
        return leftDepth < rightDepth ? leftDepth : rightDepth;
        
    }
}