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
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }

    public void postorder(Node
     node, List<Integer> ans){
        if(node == null) return;
        
        List<Node> c = node.children;
        for(int i =0;i<c.size(); i++){
            postorder(c.get(i), ans);
        }
        
        ans.add(node.val);
    }
}