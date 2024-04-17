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
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }
    
    public String dfs(TreeNode root, String tillNow){
        if(root == null){
            return "";
        }
        
        // create the string
        char curr = (char)('a' + root.val);
        tillNow =  curr + tillNow;
        
        // both chil
        if(root.left != null && root.right != null){
            return dfs(root.left, tillNow).compareTo(dfs(root.right, tillNow)) > 0? dfs(root.right, tillNow):dfs(root.left, tillNow);
        }
        // only left
         if(root.left != null){
             return dfs(root.left, tillNow);
         }
        //only right
         if(root.right != null){
             return dfs(root.right, tillNow);
         }
        return tillNow;
    }
}