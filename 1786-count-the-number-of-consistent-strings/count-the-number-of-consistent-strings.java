class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(int i =0;i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }
        int n = words.length;
        int cnt = 0;
        for(int i =0;i<n;i++){
            String s = words[i];
            for(int j =0;j<s.length();j++){
                char c = s.charAt(j);
                if(!set.contains(c)){
                    cnt++;
                    break;
                }
            }
        }
        return n - cnt;
    }
}