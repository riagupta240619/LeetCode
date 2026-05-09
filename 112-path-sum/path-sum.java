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
    public boolean paths(TreeNode root, int sum,int target){
        if(root == null) return false;
        if((root.left == null)&&(root.right == null)){
            sum+=root.val;
            if(target == sum) return true;
        }
        if(paths(root.left, sum + root.val,target)) return true;
        if(paths(root.right,sum + root.val,target)) return true;
        return false;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return paths(root, 0, targetSum);
    }
}