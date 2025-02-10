class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char c = st.pop();
            sb.insert(0, c);
        }
        return sb.toString();
    }
}
