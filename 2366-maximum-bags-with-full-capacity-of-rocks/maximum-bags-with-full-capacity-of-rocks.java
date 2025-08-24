class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        for(int i = 0;i<n;i++){
            capacity[i] -= rocks[i];
        }

        Arrays.sort(capacity);
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(additionalRocks >= capacity[i]){
                ans++;
                additionalRocks -= capacity[i];
            }
            else break;
        }
        return ans;
    }
}