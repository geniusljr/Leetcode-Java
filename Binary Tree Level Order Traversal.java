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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        
        if (root != null)
            queue1.add(root);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        while (!queue1.isEmpty()) {
            ArrayList<Integer> oneResult = new ArrayList<Integer>();
            Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
            while (!queue1.isEmpty()) {
                TreeNode curRoot = queue1.poll();
                oneResult.add(curRoot.val);
                if (curRoot.left != null)
                    queue2.add(curRoot.left);
                if (curRoot.right != null)
                    queue2.add(curRoot.right);
            }
            results.add(oneResult);
            queue1 = queue2;
        }
        return results;
    }
}