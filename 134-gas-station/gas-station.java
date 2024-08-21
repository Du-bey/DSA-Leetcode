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
        int tgas = 0;
        int start = 0;
        for(int i =0;i<n;i++){
            tgas += gas[i] - cost[i];
            if(tgas < 0){
                tgas = 0;
                start = i+1;
            }
        }
        return start;
    }
}