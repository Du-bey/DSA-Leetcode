class Solution {
    int n;
    int ans = Integer.MAX_VALUE;
    List<Integer> res;
    
    public int[] findPermutation(int[] nums) {
        n = nums.length;
        boolean[] visited = new boolean[n]; 
        List<Integer> l = new ArrayList<>();
        l.add(0);
        visited[0] = true;
        
        solve(nums, visited, l, 0);

        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    public void solve(int[] nums, boolean[] visited, List<Integer> l, int score) {
        if (score >= ans) return; 

        if (l.size() == n) {
            score += Math.abs(l.get(l.size() - 1) - nums[0]);
            if (score < ans) {
                ans = score;
                res = new ArrayList<>(l);
            }
            return;
        }

        int prev = l.get(l.size() - 1);
        
        for (int num = 0; num < n; num++) {
            if (visited[num]) continue;

            visited[num] = true;
            l.add(num);
            int newScore = score + Math.abs(prev - nums[num]);

            solve(nums, visited, l, newScore);

            l.remove(l.size() - 1);
            visited[num] = false;
        }
    }
}
