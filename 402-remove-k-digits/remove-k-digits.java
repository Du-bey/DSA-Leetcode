class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k >= n) return "0";

        char[] ch = num.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i =0;i<n;i++){
            char c = ch[i];
            int no = c - '0';
            
            while(!st.isEmpty() && k>0 && no < st.peek() - '0'){
                st.pop();
                k--;
            }
            st.push(c);
        }

        while(k>0){
            st.pop();
            k--;            
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();
        while(ans.length() > 1 && ans.charAt(0) == '0'){
            ans.deleteCharAt(0);
        }
        return ans.toString();
    }
}