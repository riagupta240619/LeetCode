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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        String ans = "";
        dfs(root, res, ans);
        return res;
    }
    public void dfs(TreeNode root, List<String> res, String ans){
        if(root == null ) return;
        if(root.left == null && root.right == null){
            ans = ans + root.val;
            res.add(ans);
            return;
        }
        dfs(root.left, res, ans + root.val  + "->");
        dfs(root.right, res, ans + root.val + "->");
    }
}