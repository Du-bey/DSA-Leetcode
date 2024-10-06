class Solution {
    public boolean areSentencesSimilar(String st1, String st2) {
        String[] s1 = st1.split(" ");
        String[] s2 = st2.split(" ");
        int n = s1.length;
        int m = s2.length;
        if(n > m) return areSentencesSimilar(st2, st1);
        
        int i =0;
        while(i < n && s1[i].equals(s2[i])) {
            ++i;
        }
        while(i < n && s1[i].equals(s2[m - n + i])){
            ++i;
        }
        return i == n;
    }
}
