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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] depth = {0};
        return isBalanced(root, depth);
    }
    
    public boolean isBalanced(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        int[] left = {0}, right = {0};
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            if (Math.abs(left[0]-right[0]) > 1)
                return false;
            depth[0] = Math.max(left[0], right[0]) + 1;
            return true;
        }
        return false;
    }
}