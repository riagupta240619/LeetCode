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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int c = 1;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> arr = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode curr = q.poll();
                arr.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(c%2==0){
                Collections.reverse(arr);
                res.add(arr);
                c++;
            }
            else{
                res.add(arr);
                c++;
            }
        }
        return res;
    }
}