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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildBST(num, 0, num.length-1);
    }
    
    public TreeNode buildBST(int[] num, int start, int end) {
        if (num.length == 0 || start > end)
            return null;
        TreeNode root = new TreeNode(num[(start+end)/2]);
        root.left = buildBST(num, start, (start+end)/2-1);
        root.right = buildBST(num, (start+end)/2+1, end);
        return root;
    }
}