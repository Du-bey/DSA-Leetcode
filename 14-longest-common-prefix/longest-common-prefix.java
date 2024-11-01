class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        int n = strs.length;
        String a = strs[0];
        String b = strs[n-1];
        for(int i =0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                break;
            }
            ans.append(a.charAt(i));
        }
        return ans.toString();
    }
}