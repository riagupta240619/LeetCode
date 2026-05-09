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
    public void preOrder(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
    public void flatten(TreeNode root) {
        if(root == null) return;
        List<Integer> l = new ArrayList<>();
        preOrder(root, l);
        l.remove(0);
        TreeNode temp = root;
        for(int i = 0;i<l.size();i++){
            temp.right= new TreeNode(l.get(i));
            temp.left = null;
            temp = temp.right;
        }
    }
}