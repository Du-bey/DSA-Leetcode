class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int ans = 0;
        int n = tasks.length;

        for(int x : tasks){
            h.put(x, h.getOrDefault(x, 0) + 1);
        }

        for(int x : h.keySet()){
            int cnt = h.get(x);
            if(cnt == 1) return -1;

            ans += (cnt + 2) / 3;
        }
        return ans;
    }
}