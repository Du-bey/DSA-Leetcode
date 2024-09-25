class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Node root = new Node();
        for(int x : arr1){
            String s = String.valueOf(x);
            Node node = root;
            for(int i =0;i<s.length();i++){
                char c = s.charAt(i);
                if(node.links[c - '0'] == null){
                    node.links[c - '0'] = new Node();
                }
                node = node.links[c - '0'];
            }
        }
        int ans = 0;
        for(int x : arr2){
            int cnt = 0;
            String s = String.valueOf(x);
            Node node = root;
            for(int i =0;i<s.length();i++){
                char c = s.charAt(i);
                if(node.links[c - '0'] == null){
                    break;
                }
                node = node.links[c - '0'];
                cnt++;
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}

class Node{
    Node[] links = new Node[26];
}