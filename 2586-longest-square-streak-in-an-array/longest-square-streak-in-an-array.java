class Solution {
    public int longestSquareStreak(int[] nums) {
        HashMap<Integer, Integer> h = new HashMap<>();
        Arrays.sort(nums);
        int ans = -1;
        for(int x : nums){
            int newfreq = 1;
            int sqrt = (int) Math.sqrt(x);
            if(sqrt * sqrt == x && h.containsKey(sqrt)){
                newfreq += h.get(sqrt);
            }
            
            ans = Math.max(ans,newfreq);
            h.put(x, newfreq);
        }
        return ans == 1 ? -1 : ans;
    }
}