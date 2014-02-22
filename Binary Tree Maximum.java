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

	public static int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null)
            return 0;
        int[] max = {Integer.MIN_VALUE};
        maxBranchSum(root, max);
        return max[0];
    }
    
    public static int maxBranchSum(TreeNode root, int[] max) {
        int leftBranchSum = root.left == null ? Integer.MIN_VALUE : maxBranchSum(root.left, max);
        int rightBranchSum = root.right == null ? Integer.MIN_VALUE : maxBranchSum(root.right, max);
        int temp = root.val + (leftBranchSum > 0 ? leftBranchSum : 0) + (rightBranchSum > 0 ? rightBranchSum : 0);
        max[0] = temp > max[0] ? temp : max[0];
        int maxBranch = leftBranchSum > rightBranchSum ? leftBranchSum : rightBranchSum;
        return root.val + (maxBranch > 0 ? maxBranch : 0);
    }
}