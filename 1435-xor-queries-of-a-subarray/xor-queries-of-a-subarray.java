class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int[] ans = new int[q.length];
        int[] pre = new int[arr.length];
        pre[0] = arr[0];
        for(int i =1;i<arr.length;i++){
            pre[i] = pre[i-1] ^ arr[i];
        }
        for(int i =0;i<q.length;i++){
            int a = q[i][0];
            int b = q[i][1];
            ans[i] = pre[b];
            if(a > 0){
                ans[i] ^= pre[a-1];
            }
        }
        return ans;
    }
}