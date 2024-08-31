class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int gsum = 0;
        int csum = 0;
        for(int i =0;i<n;i++){
            gsum += gas[i];
            csum += cost[i];
        }
        if(gsum < csum) return -1;
        int tGas = 0;
        int ans = 0;
        for(int i =0;i<n;i++){
            tGas += gas[i] - cost[i];
            if(tGas < 0){
                tGas = 0;
                ans = i+1;
            }
        }
        return ans;
    }
}