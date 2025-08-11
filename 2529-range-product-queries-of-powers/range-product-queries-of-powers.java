class Solution {
    int mod = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
        int s = queries.length;
        List<Long> power = new ArrayList<>();
        for(int i =0;i<32;i++){
            if(((1 << i) & n) != 0){
                power.add((long)(1 << i));
            }
        }
        int[] ans = new int[s];

        int ind = 0;
        for(int[] r : queries){
            int a = r[0];
            int b = r[1];
            long cnt = 1;
            for(int i =a;i<=b;i++){
                long p = power.get(i);
                p %= mod;
                cnt *= p;
                cnt %= mod;
            }
            ans[ind++] = (int)cnt;
        }
        return ans;
    }
}