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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> h = new TreeMap<>();
        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(root, 0, 0));

        while(!q.isEmpty()){
            Triplet t = q.poll();
            TreeNode node = t.val;
            int ver = t.ver;
            int lev = t.lev;
            h.putIfAbsent(ver, new TreeMap<>());
            h.get(ver).putIfAbsent(lev, new PriorityQueue<>());
            h.get(ver).get(lev).add(node.val);
            if(node.left != null) q.add(new Triplet(node.left, ver - 1, lev + 1));
            if(node.right != null) q.add(new Triplet(node.right, ver + 1, lev + 1));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : h.values()){
            List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> nodes : ys.values()){
                while(!nodes.isEmpty()){
                    temp.add(nodes.poll());
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}

class Triplet {
    TreeNode val;
    int ver;
    int lev;

    public Triplet(TreeNode val, int ver, int lev){
        this.val = val;
        this.ver = ver;
        this.lev = lev;
    }
}