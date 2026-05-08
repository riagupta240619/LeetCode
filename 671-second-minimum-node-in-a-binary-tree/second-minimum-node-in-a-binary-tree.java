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
        if(root == null) return ;
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null ) return -1;
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        Collections.sort(res);
        Set<Integer> set = new HashSet<>(res);
        res = new ArrayList<>(new LinkedHashSet<>(res));
        if(res.size() == 1) return -1;
        return res.get(1);
    }
}