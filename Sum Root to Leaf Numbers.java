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
    public int sumNumbers(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] sum = {0};
        sumNumbers(root, 0, sum);
        return sum[0];
    }
    
    public void sumNumbers(TreeNode root, int curSum, int[] totalSum) {
        if (root == null)
            return;
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            totalSum[0] += curSum;
            return;
        }
        sumNumbers(root.left, curSum, totalSum);
        sumNumbers(root.right, curSum, totalSum);
        return;
    }
}