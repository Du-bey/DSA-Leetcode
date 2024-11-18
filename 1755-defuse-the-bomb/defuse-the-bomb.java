class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if(k == 0) return ans;
        
        int st = 1, end = k, sum = 0;
        if(k < 0){
            k = -k;
            st = n - k;
            end = n - 1;
        }
        for(int i = st; i<= end;i++){
            sum += code[i];
        }

        for(int i =0;i<n;i++){
            ans[i] = sum;
            sum -= code[(st++) % n];
            sum += code[(++end) % n];
        }
        return ans;
    }
}