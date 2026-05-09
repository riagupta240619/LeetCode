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
    public void paths(TreeNode root, List<Integer> l, int sum){
        if(root == null) return ;
        if(root.left == null && root.right == null){
            sum += root.val;
            l.add(sum);
            return;
        }
        paths(root.left, l, sum + root.val);
        paths(root.right, l, sum + root.val);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> l = new ArrayList<>();
        paths(root, l, 0);
        if(l.contains(targetSum)) return true;
        return false;
    }
}