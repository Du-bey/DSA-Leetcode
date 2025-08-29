class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int i = 0;
        int j = n-2;
        int ans = 0;
        while(i < j){
            ans += piles[j];
            j -= 2;
            i++;
        }
        return ans;
    }
}