class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pfreq = new int[26];
        int pn = p.length();
        int n = s.length();
        
        for(char c : p.toCharArray()){
            pfreq[c - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        for(int j =0;j<n;j++){
            char c = s.charAt(j);
            pfreq[c - 'a']--;
            if(j - i + 1 == pn){
                if(allZeroes(pfreq)){
                    ans.add(i);
                }

                pfreq[s.charAt(i) - 'a']++;
                i++;
            }
        }
        return ans;
    }

    public boolean allZeroes(int[] pfreq){
        for(int i = 0;i<26;i++){
            if(pfreq[i] != 0) return false;
        }
        return true;
    }
}