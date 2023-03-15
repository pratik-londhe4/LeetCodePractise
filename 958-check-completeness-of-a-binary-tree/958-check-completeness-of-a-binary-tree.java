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
    public boolean isCompleteTree(TreeNode root) {
        //will do bfs to traverse left to right
        //to check complete bt, we see when we get a null node
        //the null node should be the last node
        //if we get another node after null, then it is not complete as the nodes are not left as possible
        
        //bfs 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean foundNull = false;
        
        while(q.size() > 0){
            int size = q.size();
            
            while(size > 0){      
            TreeNode node = q.poll();
            //check if tree is ended
            if(node == null)foundNull = true;
            else if(foundNull)return false;
            else {
            q.offer(node.left);
            q.offer(node.right);
            }
                size--;
        }
        }
        
        return true;
    }
}