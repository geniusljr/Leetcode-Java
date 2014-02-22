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
    public void recoverTree(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<TreeNode> inorderRes = inorder(root);
        int first = -1, second = -1;
        for (int i = 0; i < inorderRes.size()-1; i++) {
            if (inorderRes.get(i).val > inorderRes.get(i+1).val) {
                first = first == -1 ? i : first;
                second = i+1;
            }
        }
        if (first != -1 && second != -1) {
            TreeNode firstNode = inorderRes.get(first);
            TreeNode secondNode = inorderRes.get(second);
            firstNode.val ^= secondNode.val;
            secondNode.val ^= firstNode.val;
            firstNode.val ^= secondNode.val;
        }
        return;
    }
    
    ArrayList<TreeNode> inorder(TreeNode root) {
        ArrayList<TreeNode> results = new ArrayList<TreeNode>();
        if (root == null)
            return results;
        results.addAll(inorder(root.left));
        results.add(root);
        results.addAll(inorder(root.right));
        return results;
    }
}