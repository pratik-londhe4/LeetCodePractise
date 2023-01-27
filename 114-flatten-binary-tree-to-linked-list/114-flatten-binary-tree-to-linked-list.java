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
    Stack<TreeNode> pre;
    
    void preorder(TreeNode root){
        if(root == null){
            return;
        }
        
        pre.push(root);
        preorder(root.left);
        preorder(root.right);
    }
    public void flatten(TreeNode root) {
        pre = new Stack();        
        //fill stack with preorder traversal
        preorder(root);
        
        //pop nodes from stack and make linked list
        TreeNode prev = null;
            while(pre.size() > 0){
                TreeNode curr = pre.pop();
                curr.right = prev;
                curr.left = null;
                prev = curr;
            }
        
        
    }
}