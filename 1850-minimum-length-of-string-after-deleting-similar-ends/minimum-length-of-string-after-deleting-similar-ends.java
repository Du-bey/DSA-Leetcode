class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        int cnt = 0;
        while(i < j){
            char c = s.charAt(i);
            char c2 = s.charAt(j);
            if(c != c2) break;
            while(i <= j && s.charAt(i) == c2){
                i++;
                cnt++;
            }

            while(i <= j && s.charAt(j) == c){
                j--;
                cnt++;
            }
        }
        return n - cnt;
    }
}