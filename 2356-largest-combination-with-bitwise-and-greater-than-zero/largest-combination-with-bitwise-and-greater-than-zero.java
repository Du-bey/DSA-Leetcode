class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 0;
        for(int i =0;i<24;i++){
            int len = 0;
            for(int x : candidates){
                if(iBitSet(x, i)) len++;
            }
            ans = Math.max(ans, len);
        }
        return Math.max(ans, 1);
    }

    public boolean iBitSet(int n, int i){
        return (n & (1 << i)) > 0;
    }
}