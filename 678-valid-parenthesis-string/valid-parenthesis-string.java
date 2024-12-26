class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int min = 0;
        int max = 0;
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            if(c == '('){
                min++;
                max++;
            }
            else if(c == ')'){
                min = Math.max(0, min - 1);
                max--;
            }
            else{
                min = Math.max(0, min - 1);
                max++;
            }
            if(max < 0) return false;
        }
        return min == 0;
    }
}