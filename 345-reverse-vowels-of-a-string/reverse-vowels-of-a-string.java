class Solution {
    public String reverseVowels(String str) {
        Set<Character> s = new HashSet<>();
        s.add('a');
        s.add('e');
        s.add('i');
        s.add('o');
        s.add('u');
        s.add('A');
        s.add('E');
        s.add('I');
        s.add('O');
        s.add('U');

        char[] st = str.toCharArray();

        int n = str.length();
        int i =0;
        int j = n - 1;

        while(i <j){
            char c = st[i];
            char c2 = st[j]; 
            if(s.contains(c) && s.contains(c2)){
                st[i++] = c2;
                st[j--] = c;
            }
            else if(s.contains(c)){
                j--;
            }
            else i++;
        }
        return new String(st);
    }
}