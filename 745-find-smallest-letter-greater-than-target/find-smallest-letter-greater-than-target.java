class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int a = target - 'a';
        for(char c : letters){
            int b = c - 'a';
            if(b > a) return c;
        }

        return letters[0];
    }
}