class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int ans = -200000;
        int n = energy.length;

        for(int i = n-k-1; i>=0;i--){
            energy[i] += energy[i+k];
        }
        for(int i = 0;i<n;i++){
            ans = Math.max(ans, energy[i]);
        }
        return ans;
    }
}