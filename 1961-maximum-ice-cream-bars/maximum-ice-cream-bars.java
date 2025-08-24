class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnt = 0;
        for(int x : costs){
            coins -= x;
            if(coins < 0) break;
            cnt++;
        }
        return cnt;
    }
}