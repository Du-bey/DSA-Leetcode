class Solution {
    public long countOfSubstrings(String word, int k) {
        HashMap<Character, Integer> h = new HashMap<>();
        int rest = 0, i = 0, n = word.length(), last = n;
        long ans = 0;

        int[] nextCons = new int[n];
        for(int ind = n-1;ind>=0;ind--){
            nextCons[ind] = last;
            if(!isVowel(word.charAt(ind))){
                last = ind;
            }
        }

        for(int j =0;j<n;j++){
            char c = word.charAt(j);
            if(isVowel(c)){
                h.put(c, h.getOrDefault(c, 0) + 1);
            }
            else rest++;

            while(rest > k){
                char ch = word.charAt(i);
                if(isVowel(ch)){
                    h.put(ch, h.get(ch) - 1);
                    if(h.get(ch) == 0) h.remove(ch);
                }
                else rest--;
                i++;
            }
            while(h.size() == 5 && rest == k){
                ans += nextCons[j] - j;
                char ch = word.charAt(i);
                if(isVowel(ch)){
                    h.put(ch, h.get(ch) - 1);
                    if(h.get(ch) == 0) h.remove(ch);
                }
                else rest--;
                i++;
            }
        }
        return ans;
    }

    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }
}