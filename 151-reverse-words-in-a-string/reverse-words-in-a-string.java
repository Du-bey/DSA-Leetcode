class Solution {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");
        int n = s.length();
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        Stack<String> st = new Stack<>();
        for(int i =0;i<n;i++){
            if(c[i] == ' '){
                st.push(temp.toString());
                temp.setLength(0);
            }
            else{
                temp.append(c[i]);
            }
        }
        st.push(temp.toString());
        while(!st.isEmpty()){
            sb.append(st.pop());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString(); 
    }
}