class Solution {
    int n;
    int i = 0;
    public TreeNode recoverFromPreorder(String t) {
        n = t.length();
        return solve(t, 0);
    }

    public TreeNode solve(String s, int lev){
        if(i >= n) return null;
        
        int j = i;
        while(j < n && s.charAt(j) == '-'){
            j++;
        }
        int l = j - i;
        if(l != lev) return null;
        i = j;
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            i++;
        }
        TreeNode root = new TreeNode(num);
        root.left = solve(s, l+1);
        root.right = solve(s, l+1);
        return root;
    }
}