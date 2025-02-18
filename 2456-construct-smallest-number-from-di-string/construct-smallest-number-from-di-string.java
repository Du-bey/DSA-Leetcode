class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        Stack<Character> st = new Stack<>();
        for(int i =0;i<=n;i++){
            st.push((char) ('0' + cnt));
            cnt++;
            if(i == n || pattern.charAt(i) == 'I'){
                while(!st.isEmpty()){
                    sb.append(st.pop());
                }
            }
        }
        return sb.toString();
    }
}