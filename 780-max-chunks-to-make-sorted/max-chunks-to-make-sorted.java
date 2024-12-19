class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = arr[0];
        suf[n-1] = arr[n-1];
        for(int i =1;i<n;i++){
            pre[i] = Math.max(pre[i-1], arr[i]);
        }
        for(int i = n-2;i>=0;i--){
            suf[i] = Math.min(suf[i+1], arr[i]);
        }

        int ans = 0;
        for(int i =0;i<n;i++){
            int maxBefore = (i > 0) ? pre[i-1] : -1;
            int minAfter = suf[i];
            if(maxBefore < minAfter) ans++;
        }
        return ans;
    }
}