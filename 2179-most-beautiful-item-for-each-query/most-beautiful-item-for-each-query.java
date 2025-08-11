class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int qn = queries.length;
        int[] ans = new int[qn];

        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        int max = 0;
        for(int i =0;i<n;i++){
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }

        for(int i =0;i<qn;i++){
            ans[i] = bs(items, queries[i]);
        }
        return ans;
    }

    public int bs(int[][] items, int q){
        int n = items.length;
        int l = 0;
        int h = n-1;

        int ans = 0;
        while(l <= h){
            int mid = l + (h-l)/2;
            int mp = items[mid][0];
            if(mp > q){
                h = mid - 1;
            }
            else{
                ans = items[mid][1];
                l = mid + 1;
            }
        }
        return ans;
    }
}