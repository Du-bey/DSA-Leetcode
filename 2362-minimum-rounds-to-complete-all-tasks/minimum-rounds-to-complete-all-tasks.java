class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int ans = 0;
        int cnt = 1;
        int n = tasks.length;

        for(int i = 1;i<n;i++){
            if(tasks[i] == tasks[i-1]) cnt++;
            else{
                ans += ((cnt + 2) / 3);
                if(cnt == 1) return -1;
                cnt = 1;
            }
        }
        ans += ((cnt + 2) / 3);
        return (cnt == 1) ? -1 : ans;
    }
}