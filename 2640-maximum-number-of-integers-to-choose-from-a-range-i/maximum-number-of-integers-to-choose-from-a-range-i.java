class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> h = new HashSet<>();

        for(int x : banned) h.add(x);
        int sum = 0;
        int ans = 0;
        for(int i =1;i<=n;i++){
            if(!h.contains(i)){
                sum += i;
                if(sum <= maxSum) ans++;
                else break;
            }
        }
        return ans;
    }
}