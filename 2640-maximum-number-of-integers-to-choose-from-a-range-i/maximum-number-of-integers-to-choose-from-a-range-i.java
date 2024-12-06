class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int size = banned.length;
        HashSet<Integer> h = new HashSet<>();
        for(int x : banned) h.add(x);

        int cnt = 0;
        for(int i =1;i<=n;i++){
            if(i <= maxSum && !h.contains(i)){
                maxSum -= i;
                cnt++;
            }
        }
        return cnt;
    }
}