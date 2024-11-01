class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if(n != m) return false;
        String t = goal + goal;
        return t.indexOf(s) != -1;
    }
}