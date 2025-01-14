class Solution {
    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        for(int n : nums){
            Node node = root;
            for(int i = 31;i>=0;i--){
                int bit = (n >> i) & 1;
                if(node.links[bit] == null){
                    node.links[bit] = new Node();
                }
                node = node.links[bit];
            }
        }

        int ans = 0;
        for(int n : nums){
            Node node = root;
            int max = 0;
            for(int i = 31;i>=0;i--){
                int bit = (n >> i) & 1;
                if(node.links[1 - bit] != null){
                    max = max | (1 << i);
                    node = node.links[1 - bit];
                }
                else{
                    node = node.links[bit];
                }
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }
}

class Node{
    Node[] links = new Node[2];
}