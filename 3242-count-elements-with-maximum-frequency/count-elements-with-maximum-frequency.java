class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int max = 0;
        int ans = 0;
        for(int x : nums){
            int cnt = h.getOrDefault(x, 0);
            h.put(x, cnt + 1);
            max = Math.max(max, cnt + 1);
        }

        for(int x : h.keySet()){
            if(h.get(x) == max) ans++;
        }
        return ans * max;
    }
}