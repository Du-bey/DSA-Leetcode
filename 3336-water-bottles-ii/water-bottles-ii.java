class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = 0;
        int empty = 0;
        int full = numBottles;
        while(full >= numExchange){
            int consumed = numExchange;
            full -= consumed;
            ans += consumed;
            numExchange++;
            full++;
            empty = consumed;
        }

        if(empty == numExchange) ans++;
        return ans + full;
    }
}