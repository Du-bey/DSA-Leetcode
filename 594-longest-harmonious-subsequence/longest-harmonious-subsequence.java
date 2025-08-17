class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        int ans = 0;
        
        for(int x : nums){
            h.put(x, h.getOrDefault(x, 0) + 1);
        }

        for(int x : h.keySet()){
            if(h.containsKey(x + 1)){
                ans = Math.max(ans, h.getOrDefault(x, 0) + h.get(x+1));
            }
        }

        return ans;
    }
}