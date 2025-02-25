class Solution {
    public int numOfSubarrays(int[] arr) {
        int k = 1;
        int MOD = 1_000_000_007;
        int n = arr.length;
        for(int i =0;i<n;i++){
            arr[i] %= 2;
        }
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(0, 1);
        int sum = 0;
        int ans = 0;
        for(int i =0;i<n;i++){
            sum += arr[i];
            sum %= 2;
            ans = (ans + h.getOrDefault(1 - sum, 0)) % MOD;
            h.put(sum, h.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}