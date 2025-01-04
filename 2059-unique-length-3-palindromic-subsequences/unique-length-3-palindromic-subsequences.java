class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int ans = 0;
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            set.add(c);
        }
        for(char c : set){
            int left = -1;
            int right = -1;
            for(int i =0;i<n;i++){
                if(s.charAt(i) == c){
                    if(left == -1) left = i;
                    right = i;
                }
            }
            HashSet<Character> st = new HashSet<>();
            for(int mid = left + 1; mid < right;mid++){
                st.add(s.charAt(mid));
            }
            ans += st.size();
        }
        return ans;
    }
}