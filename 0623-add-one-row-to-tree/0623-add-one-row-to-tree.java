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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        
        // edge cas where depth is 1
        if(depth == 1){
              TreeNode newNodeLeft = new TreeNode(val);
            
            newNodeLeft.left = root;
            return newNodeLeft;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        
        q.add(root);
        int currDepth = 1;
        while(currDepth < depth-1){
                    Queue<TreeNode> tmp = new ArrayDeque<>();
            while(!q.isEmpty()){
                TreeNode curr = q.remove();
                if(curr.left != null)tmp.add(curr.left);
                if(curr.right != null)tmp.add(curr.right);
            }
            currDepth++;
            q = tmp;

        }
        
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            TreeNode temp = curr.left;
            curr.left = new TreeNode(val);
            curr.left.left = temp;
            
             temp = curr.right;
            curr.right = new TreeNode(val);
            curr.right.right = temp;
        }
        return root;
    }
}