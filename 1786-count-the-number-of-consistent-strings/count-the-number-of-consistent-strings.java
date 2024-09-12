class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        int ch = 0;
        for(int i =0;i<allowed.length();i++){
            char c = allowed.charAt(i);
            ch |= (1 << (c-'a'));
        }
        int ans = words.length;
        for(String s : words){
            for(int j =0;j<s.length();j++){
                char c = s.charAt(j);
                if((ch & (1 << (c - 'a'))) == 0){
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}