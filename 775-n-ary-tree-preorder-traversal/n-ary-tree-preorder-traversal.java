/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    public void preorder(Node node, List<Integer> ans){
        if(node == null) return;
        

        ans.add(node.val);
        List<Node> c = node.children;
        for(int i =0;i<c.size(); i++){
            preorder(c.get(i), ans);
        }
    }
}