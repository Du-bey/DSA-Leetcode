class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;

        int i = 0;
        HashMap<Integer, Integer> h = new HashMap<>();

        int pair = 0;
        for(int j =0;j<n;j++){
            int x = nums[j];
            pair += h.getOrDefault(x, 0);
            System.out.println(pair);
            
            h.put(x, h.getOrDefault(x, 0) + 1);
            while(pair >= k){
                int y = nums[i];
                ans += n - j;
                int freq = h.get(y);
                h.put(y, freq - 1);
                pair -= h.get(y);
                i++;
            }
        }
        return ans;
    }
}