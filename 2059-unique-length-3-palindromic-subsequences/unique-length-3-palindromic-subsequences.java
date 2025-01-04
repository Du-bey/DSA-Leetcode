class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int ans = 0;
        int[] pre = new int[26];
        int[] post = new int[26];
        Arrays.fill(pre, -1);
        Arrays.fill(post, -1);
        
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            int ascii = c - 'a';
            if(pre[ascii] == -1) pre[ascii] = i;
            post[ascii] = i;
            set.add(c);
        }

        for(char c : set){
            int left = pre[c - 'a'];
            int right = post[c - 'a'];
            
            HashSet<Character> st = new HashSet<>();
            for(int mid = left + 1; mid < right;mid++){
                st.add(s.charAt(mid));
            }
            ans += st.size();
        }
        return ans;
    }
}