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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return results;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        boolean left = false;
        while (!stack.isEmpty()) {
            ArrayList<Integer> oneResult = new ArrayList<Integer>();
            Stack<TreeNode> stack2 = new Stack<TreeNode>();
            while (!stack.isEmpty()) {
                TreeNode top = stack.pop();
                if (left) {
                    if (top.right != null)
                        stack2.push(top.right);
                    if (top.left != null)
                        stack2.push(top.left);
                } else {
                    if (top.left != null)
                        stack2.push(top.left);
                    if (top.right != null)
                        stack2.push(top.right);
                }
                oneResult.add(top.val);
            }
            if (!oneResult.isEmpty()) {
                results.add(oneResult);
                stack = stack2;
                left = !left;
            } else {
                return results;
            }
        }
        return results;
    }
}