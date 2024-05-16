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
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(root, 0, 0));

        while(!q.isEmpty()){
            Triplet t = q.peek();
            TreeNode node = t.val;
            int ver = t.ver;
            int val = t.lev;
            q.poll(); 
            map.putIfAbsent(ver, new TreeMap<>());
            map.get(ver).putIfAbsent(val, new PriorityQueue<>());
            map.get(ver).get(val).offer(node.val);
            if(node.left != null) q.add(new Triplet(node.left, ver - 1, val +1));
            if(node.right != null) q.add(new Triplet(node.right, ver + 1, val +1));
        }

        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
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