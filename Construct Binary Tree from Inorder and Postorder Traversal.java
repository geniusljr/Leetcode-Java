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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd || inStart > inEnd || postEnd-postStart != inEnd-inStart)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            int left = idx-inStart;
            TreeNode leftRoot = buildTree(inorder, inStart, idx-1, postorder, postStart, postStart+left-1);
            root.left = leftRoot;
            TreeNode rightRoot = buildTree(inorder, idx+1, inEnd, postorder, postStart+left, postEnd-1);
            root.right = rightRoot;
        }
        return root;
    }
}