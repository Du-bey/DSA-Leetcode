class Solution {
    public int longestBalanced(String s) {
        int n = s.length();

        int ans = 1;
        for(int i =0;i<n;i++){
            int[] freq = new int[26];
            for(int j =i;j<n;j++){
                boolean br = false;
                int cj = s.charAt(j) - 'a';
                freq[cj]++;
                int f = freq[cj];
                for(int x : freq){
                    if(x != 0 && x != f){
                        br = true;
                        break; 
                    }
                }
                
                if(!br) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}