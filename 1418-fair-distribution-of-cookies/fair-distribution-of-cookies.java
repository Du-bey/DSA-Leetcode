class Solution {
    int ans = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
       int[] child = new int[k];
       solve(0, child, cookies, k);
       return ans;
    }

    public void solve(int i, int[] child, int[] cookies, int k){
        int n = cookies.length;
        if(i >= n){
            int temp = Integer.MIN_VALUE;
            for(int x : child){
                temp = Math.max(x, temp);
            }
            ans = Math.min(ans, temp);
            return;
        }

        for(int j=0;j<k;j++){
            child[j] += cookies[i];
            solve(i+1, child, cookies, k);
            child[j] -= cookies[i];
        }
    }
}