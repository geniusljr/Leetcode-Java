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
    public boolean isValidBST(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean isValid(TreeNode root, int minV, int maxV) {
        if (root == null)
            return true;
        if (root.val <= minV || root.val >= maxV)
            return false;
        return isValid(root.left, minV, root.val) && isValid(root.right, root.val, maxV);
    }
}