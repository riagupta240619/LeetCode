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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // List<Integer> arr1 = new ArrayList<>();
        // List<Integer> arr2 = new ArrayList<>();
        // preOrder(p,arr1);
        // preOrder(q,arr2);
        // if(arr1.size() != arr2.size()) return false;
        // for(int i = 0;i<arr1.size();i++){
        //     if(!arr1.get(i).equals(arr2.get(i))){
        //         return false;
        //     }
        // }
        // return true;
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
    // private void preOrder(TreeNode root, List<Integer> res){
    //     if(root == null){
    //         res.add(-1);
    //         return;
    //     }
    //     res.add(root.val);
    //     preOrder(root.left, res);
    //     preOrder(root.right, res);
    // }
}