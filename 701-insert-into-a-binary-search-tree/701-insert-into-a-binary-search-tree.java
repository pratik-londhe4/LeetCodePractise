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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //0.if root is null then return the node to be inserted
        if(root == null){
            return new TreeNode(val);
        }
       
        //1.if root val is equal to value then return root
        
        //2.if root.val is greater the val then alter left subtree
        if(root.val > val){
            root.left = insertIntoBST(root.left,val);
        }
        //3.if root.val is less than the val then alter right subtree
        else{
            root.right = insertIntoBST(root.right,val);
        }
        //4.return the root
        return root;
        
       
    }
}