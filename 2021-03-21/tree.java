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
 //通过找到最大深度 + 1
 //递归的方法解决，退出条件是节点为null
 //时间复杂度O(n) 空间复杂度O(root的高度)
 class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;

        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);

        return Math.max(left_depth, right_depth) + 1;
    }
}