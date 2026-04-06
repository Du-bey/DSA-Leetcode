class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();

        int l = 0;
        int cnt = 0;
        int ans = 0;
        for(int r = 0;r <n;r++){
            if(blocks.charAt(r) == 'B') cnt++;

            if(r - l + 1 == k){
                ans = Math.max(ans, cnt);
                if(blocks.charAt(l++) == 'B') cnt--;
            }
        }

        return k - ans;
    }
}