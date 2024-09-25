class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> h = new HashSet<>();
        for(int n : arr1){
            String s = String.valueOf(n);
            String prefix = "";
            for(char ch : s.toCharArray()){
                prefix += ch;
                h.add(prefix);
            }
        }
        int ans = 0;
        for(int n : arr2){
            String s = String.valueOf(n);
            String prefix = "";
            for(char ch : s.toCharArray()){
                prefix += ch;
                if(h.contains(prefix)){
                    ans = Math.max(ans, prefix.length());
                }
            }
        }
        return ans;
    }
}