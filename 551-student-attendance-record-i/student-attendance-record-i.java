class Solution {
    public boolean checkRecord(String s) {
        int n = s.length();
        int l = 0;
        int a = 0;
        
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            if(c == 'P'){
                l = 0;
            }
            else if(c == 'A'){
                l = 0;
                a++;
                if(a > 1) return false;
            }
            else if(c == 'L'){
                l++;
                if(l >= 3) return false;
            }
        }
        return true;
    }
}