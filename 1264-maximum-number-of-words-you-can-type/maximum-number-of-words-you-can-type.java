class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int cnt = 0;
        HashSet<Character> h = new HashSet<>();
        for(char c : brokenLetters.toCharArray()) h.add(c);

        boolean found = false;

        for(char c : text.toCharArray()){
            if(c == ' '){
                if(!found) cnt++;
                found = false;
            }
            else if(h.contains(c)){
                found = true;
            }
        }
        if(!found) cnt++;
        return cnt;
    }
}