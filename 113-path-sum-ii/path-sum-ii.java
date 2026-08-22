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
    public void paths(TreeNode root, List<List<Integer>> l, int sum, int target, List<Integer> arr){
        if(root == null) return ;
        if(root.left == null && root.right == null){
            sum += root.val;
            arr.add(root.val);
            if(sum == target) {
                l.add(new ArrayList<>(arr));
            }
            arr.remove(arr.size() - 1);
            return;
        }
        arr.add(root.val);
        paths(root.left, l, sum + root.val, target, arr);
        paths(root.right, l, sum + root.val, target,arr);
        arr.remove(arr.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        paths(root, res, 0, targetSum, l);
        return res;
    }
}
