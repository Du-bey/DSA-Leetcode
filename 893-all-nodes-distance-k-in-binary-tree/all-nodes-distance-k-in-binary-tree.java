/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> p = new HashMap<>();
        markParent(root, p);
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.put(target, true);
        int lev = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(lev == k) break;
            lev++;
            for(int i =0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left != null && vis.get(node.left) == null){
                    q.add(node.left);
                    vis.put(node.left, true);
                }
                if(node.right != null && vis.get(node.right) == null){
                    q.add(node.right);
                    vis.put(node.right, true);
                }
                TreeNode pnode = p.get(node);
                if(pnode != null && vis.get(pnode) == null){
                    q.add(pnode);
                    vis.put(pnode, true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            ans.add(node.val);
        }
        return ans;
    }

    public void markParent(TreeNode root, Map<TreeNode, TreeNode> p){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                p.put(node.left, node);
                q.add(node.left);
            }
            if(node.right != null){
                p.put(node.right, node);
                q.add(node.right);
            }
        }
    }
}