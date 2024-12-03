class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int sn = spaces.length;
        int ind = 0;
        int i =0;
        while(i < n){
            if(ind < sn && i == spaces[ind]){
                sb.append(" ");
                ind++;
            }
            else{
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
}