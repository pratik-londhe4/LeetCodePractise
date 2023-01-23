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
        List<List<Integer>> ans = new ArrayList();
        if(root == null){
            return ans;
        }
        
        Queue<TreeNode> q = new ArrayDeque();
        
        q.add(root);
        int level = 0;

        
        while(q.size() > 0){
            int size = q.size();
            
            List<Integer> currentLevel = new ArrayList();
            
            while(size > 0){
                TreeNode rnode = q.remove();
                
                currentLevel.add(rnode.val);
                
                if(rnode.left != null){
                    q.add(rnode.left);
                }
                if(rnode.right != null){
                    q.add(rnode.right);
                }
                size--;
            }
            
            if(level % 2 != 0){
             Collections.reverse(currentLevel);
            }
                ans.add(currentLevel);
            level++;

            }
        return ans;
        }
    }
