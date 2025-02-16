class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        Arrays.fill(res, -1);
        boolean[] vis = new boolean[n + 1];
        backtrack(0, n, res, vis);
        return res;
    }

    public boolean backtrack(int i, int n, int[] res, boolean[] vis) {
        if (i == res.length) {
            return true;
        }
        if (res[i] != -1) {
            return backtrack(i + 1, n, res, vis);
        }

        for (int num = n; num >= 1; num--) {
            if (vis[num]) continue;
            vis[num] = true;
            res[i] = num;

            if (num == 1) {
                if (backtrack(i + 1, n, res, vis)) return true;
            } else {
                int j = i + num;
                if (j < res.length && res[j] == -1) {
                    res[j] = num;
                    if (backtrack(i + 1, n, res, vis)) return true;
                    res[j] = -1;
                }
            }

            vis[num] = false;
            res[i] = -1;
        }

        return false;
    }
}
