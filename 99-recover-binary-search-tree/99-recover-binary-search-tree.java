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
    ArrayList<Integer> in  = new ArrayList<>();
    
    public void inorder(TreeNode root){
        if(root == null)return;
        
        inorder(root.left);
        //
        in.add(root.val);
        //
        inorder(root.right);
    }
    
     void change(TreeNode root, int a , int b){
		if(root == null)return;
		change(root.left,a,b);
		//do
		if(root.val == a)root.val = b;
		else if(root.val == b)root.val = a;
		//
		change(root.right,a,b);
	}
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        //find peak in the array and swap them.
		int a = 0;
		int b = 0;
		int prev = 0;
		int curr = 1;
		boolean flag = false;
		while(curr < in.size()){
			if(in.get(curr) < in.get(prev) && flag == true){
				b = in.get(curr);
				break;
			}else if(in.get(curr) < in.get(prev)){
				a = in.get(prev);
				b = in.get(curr);
				flag = true;
			}
			prev++;
			curr++;
		}
        
        change(root,a,b);

    }
}