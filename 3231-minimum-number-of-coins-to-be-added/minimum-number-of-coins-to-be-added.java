class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int s = coins.length;
        int ans = 0;
        int i = 0;
        long max = 0;
        
        while(max < target){
            if(i < s && coins[i] <= max + 1){
                max += coins[i++];
            }
            else{
                max += (max + 1);
                ans++;
            }
        }
        return ans;
    }
}