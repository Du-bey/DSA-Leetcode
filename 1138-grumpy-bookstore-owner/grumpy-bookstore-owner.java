class Solution {
    public int maxSatisfied(int[] c, int[] g, int min) {
        int n = c.length;
        int ans = 0;
        int i = 0;
        int sum = 0;

        for(int ind = 0;ind < n;ind++){
            if(g[ind] == 0){
                sum +=c[ind];
            }
        }

        for(int j = 0;j<n;j++){
            if(g[j] == 1){
                sum += c[j];
            }

            while(j - i + 1 > min){
                if(g[i] == 1){
                    sum -= c[i];
                }
                i++;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}