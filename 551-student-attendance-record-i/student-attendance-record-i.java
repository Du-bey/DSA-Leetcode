class Solution {
    public boolean checkRecord(String s) {
        int acnt = 0;
        int n = s.length();
        int lstart = 0;
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            if(c == 'A') acnt++;
            if(c == 'L') lstart++;
            else lstart = 0;
            if(lstart == 3 || acnt == 2) return false;
        }
        return true;
    }
}