/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return generateTrees(1, n);
    }
    
    public ArrayList<TreeNode> generateTrees(int begin, int end) {
        ArrayList<TreeNode> results = new ArrayList<TreeNode>();
        if (begin > end) {
            results.add(null);
        } else if (begin == end) {
            results.add(new TreeNode(begin));
        } else {
            for (int i = begin; i <= end; i++) {
                ArrayList<TreeNode> left = generateTrees(begin, i-1);
                ArrayList<TreeNode> right = generateTrees(i+1, end);
                for (TreeNode leftChild : left) {
                    for (TreeNode rightChild : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftChild;
                        root.right = rightChild;
                        results.add(root);
                    }
                }
            }
        }
        return results;
    }
}