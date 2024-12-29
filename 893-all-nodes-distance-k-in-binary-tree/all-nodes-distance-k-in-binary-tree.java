class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> h = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                h.put(node.left, node);
                q.add(node.left);
            }
            if(node.right != null){
                h.put(node.right, node);
                q.add(node.right);
            }
        }
        q.add(target);

        List<Integer> ans = new ArrayList<>();
        int dis = 0;
        HashSet<TreeNode> vis = new HashSet<>();
        vis.add(target);
        while(!q.isEmpty()){
            int size = q.size();
            if(dis == k) break;
            dis++;
            for(int i =0;i<size;i++){
                TreeNode node = q.poll();
                TreeNode par = h.get(node);

                if(node.left != null && !vis.contains(node.left)){
                    q.add(node.left);
                    vis.add(node.left);
                }
                if(node.right != null && !vis.contains(node.right)){
                    q.add(node.right);
                    vis.add(node.right);
                }
                if(par != null && !vis.contains(par)){
                    q.add(par);
                    vis.add(par);
                }
            }
        }
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}