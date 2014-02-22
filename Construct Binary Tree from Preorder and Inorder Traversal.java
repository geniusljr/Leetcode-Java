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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd || preEnd-preStart != inEnd-inStart)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            int left = idx-inStart;
            TreeNode leftRoot = buildTree(preorder, preStart+1, preStart+left, inorder, inStart, idx-1);
            root.left = leftRoot;
            TreeNode rightRoot = buildTree(preorder, preStart+left+1, preEnd, inorder, idx+1, inEnd);
            root.right = rightRoot;
        }
        return root;
    }
}