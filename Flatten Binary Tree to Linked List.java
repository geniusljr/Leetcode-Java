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
    public void flatten(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        preOrder(root);
    }
    
    public TreeNode preOrder(TreeNode root) {
        if (root == null)
            return null;
        TreeNode leftFlat = root.left == null ? root : preOrder(root.left);
        TreeNode rightFlat = root.right == null ? leftFlat : preOrder(root.right);
        leftFlat.right = root.right;
        root.right = root.left == null ? root.right : root.left;
        leftFlat.left = null;
        root.left = null;
        return rightFlat;
    }
}