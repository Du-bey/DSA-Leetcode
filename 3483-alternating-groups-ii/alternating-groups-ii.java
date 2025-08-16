class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int i = 0;
        int n = colors.length;
        int ans = 0;
        for(int j = 1;j<n+k-1;j++){
            if(colors[j % n] != 1 - colors[(j-1+n)%n]){
                i = j;
            }
            if(j - i + 1 == k){
                ans += 1;
                i++;
            }
        }
        return ans;
    }
}