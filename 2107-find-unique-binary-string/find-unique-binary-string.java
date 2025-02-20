class Solution {
    String ans;
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>(Arrays.asList(nums));
        solve(set, "", nums[0].length());
        return ans;
    }

    public void solve(Set<String> set, String s, int n){
        if(s.length() == n){
            if(!set.contains(s)){
                ans = s;
                return;
            }
            return;
        }
        solve(set, s + '0', n);
        solve(set, s + '1', n);
        if(ans != null) return;
    }
}