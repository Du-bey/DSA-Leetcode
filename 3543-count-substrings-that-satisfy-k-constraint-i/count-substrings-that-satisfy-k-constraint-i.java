class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int i = 0;
        int ans = 0;
        int one = 0;
        int zero = 0;

        for(int j = 0;j < n;j++){
            char c = s.charAt(j);
            if(c == '0') zero++;
            if(c == '1') one++;

            while(zero > k && one > k){
                char ch = s.charAt(i++);
                if(ch == '0') zero--;
                if(ch == '1') one--;
            }

            ans += j - i + 1;
        }
        return ans;
    }
}