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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode u = q.poll();
            if(u == null){
                sb.append("n ");
                continue;
            }
            sb.append(u.val + " ");
            q.add(u.left);
            q.add(u.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] vals = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i =1;i<vals.length;i++){
            TreeNode par = q.poll();
            if(!vals[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                par.left = left;
                q.add(left);
            }
            i++;
            if(!vals[i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(vals[i]));;
                par.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));