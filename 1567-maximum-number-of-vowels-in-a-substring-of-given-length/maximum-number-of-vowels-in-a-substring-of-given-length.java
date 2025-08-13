class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int cnt = 0;
        int i = 0;
        int ans = 0;
        for(int j =0;j<n;j++){
            char ch = s.charAt(j);
            if(isVowel(ch)) cnt++;
            
            while(j - i + 1 == k){
                ans = Math.max(ans, cnt);
                char c = s.charAt(i);
                i++;
                if(isVowel(c)) cnt--;
            }
            
        }   
        return ans;
    }

    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}