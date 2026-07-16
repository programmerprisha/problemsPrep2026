/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int val) {
        if (node == null) {
            return 0; 
        }

        int answer = 0; 
        if (node.val >= val) {
            answer = 1; 
        }
        int compute = Math.max(node.val, val);

        return answer + dfs(node.left, compute) + dfs(node.right, compute); 

    }
}
