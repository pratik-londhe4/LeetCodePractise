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
    public boolean isSameTree(TreeNode p, TreeNode q) {
      String in1 = inorderPrint(p);
        String in2 = inorderPrint(q);
        System.out.println(in1);
        System.out.println(in2);
        return in1.equals(in2) && preorderPrint(p).equals(preorderPrint(q));
    }
    
    
    
    String inorderPrint(TreeNode p){    
    
    ArrayList<Integer> arr = new ArrayList();
        inorder(p,arr);
        String ans = "";
        for(int i = 0 ; i < arr.size(); i++){
            ans+=arr.get(i);
        }
        
        return ans;
        
    }
    
    void inorder(TreeNode p, ArrayList<Integer> arr){
        if(p == null){
            arr.add(-1);
            return;
        }
        inorder(p.left,arr);
        arr.add(p.val);
        inorder(p.right,arr);
    }
    
    
    String preorderPrint(TreeNode p){
         ArrayList<Integer> arr = new ArrayList();
        preorder(p,arr);
        String ans = "";
        for(int i = 0 ; i < arr.size(); i++){
            ans+=arr.get(i);
        }
        
        return ans;
        
    }
    
    void preorder(TreeNode p, ArrayList<Integer> arr){
        if(p == null){
            arr.add(-1);
            return;
        }
        arr.add(p.val);
        preorder(p.left,arr);
        preorder(p.right,arr);
    }
}