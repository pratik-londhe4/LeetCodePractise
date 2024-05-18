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
    
    int res = 0;
    public int distributeCoins(TreeNode root) {
        
        dfs(root);
        return this.res;
    }
    
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left_extra = dfs(root.left);
        int right_extra = dfs(root.right);
        
        
        int extra_coins = root.val + left_extra + right_extra - 1;
        this.res+=Math.abs(extra_coins);
        return extra_coins;
    }
}