/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    void encode(TreeNode root , StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        
        sb.append(root.val+",");
        encode(root.left,sb);
        encode(root.right,sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encode(root,sb);
        
        return sb.toString();
        
        
    }
    
    int idx = 0;
    TreeNode decode(String[] tree){
        String val = tree[idx];
        idx++;
        
        if(val.equals("null") == true){
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = decode(tree);
        root.right = decode(tree);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      String[] arr = data.split(",");        
        return decode(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));