class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for(int i =0;i<=n;i++){
            String s = String.valueOf(i*i);
            if(partition(0, s, i, 0)) ans += i*i;
        }
        return ans;
    }

    public boolean partition(int i, String s, int t, int cur){
        int n = s.length();
        if(i == s.length() && cur == t) return true;
        
        for(int j = i;j<n;j++){
            String bef = s.substring(i, j+1);
            int befNum = Integer.parseInt(bef);
            if(partition(j+1, s, t, befNum + cur)) return true;
        }
        return false;
    }
}