class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for(char c : s.toCharArray()){
            if(c != '#') s1.push(c);
            else{
                if(!s1.isEmpty()) s1.pop();
            }
        }

        for(char c : t.toCharArray()){
            if(c != '#') s2.push(c);
            else{
                if(!s2.isEmpty()) s2.pop();
            }
        }

        while(!s1.isEmpty() && !s2.isEmpty()){
            char c1 = s1.pop();
            char c2 = s2.pop();
            if(c1 != c2) return false;
        }
        return s1.isEmpty() && s2.isEmpty();
    }
}