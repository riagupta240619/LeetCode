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
    int res_count = 0;
    int sum = 0;
    int total_nodes = 0;
    public static boolean check(int a, int b){
        if(a == b) return true;
        return false;
    }
    public void dfs(TreeNode temp) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            sum += node.val;
            total_nodes++;

            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }
    public int averageOfSubtree(TreeNode root) {
        if (root  == null) return 0;
        if(root.left == null && root.right == null) return 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode temp = q.poll();
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                if(temp.left == null && temp.right == null) res_count++;
                else{
                    sum = 0;
                    total_nodes = 0;
                    dfs(temp);
                    int average = sum/total_nodes;
                    if(check(temp.val, average)){
                        res_count++;
                    }
                }
            }
        }
        return res_count;
    }
}