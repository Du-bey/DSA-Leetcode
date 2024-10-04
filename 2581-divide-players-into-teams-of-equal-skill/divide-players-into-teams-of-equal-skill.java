class Solution {
    public long dividePlayers(int[] skill) {
        int[] h = new int[1001];
        int tot = 0;
        for(int x : skill){
            tot += x;
            h[x]++;
        }
        int n = skill.length;
        tot *= 2;
        if((tot) % n != 0) return -1;
        int sum = tot / n;
        
        long ans = 0;
        for(int x : skill){
            if(h[x] > 0){
                int oth = sum - x;
                if(h[oth] < 1) return -1;
                ans += x * oth;
                h[x]--;
                h[oth]--;
            }
        }
        return ans;
    }
}

