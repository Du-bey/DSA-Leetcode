class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int x : apple) sum += x;
        Arrays.sort(capacity);

        int n = capacity.length;
        int ans = 0;
        
        for(int i = n-1; i>=0;i--){
            int c = capacity[i];
            sum -= c;
            ans++;
            if(sum <= 0) return ans;
        }

        return ans;
    }
}