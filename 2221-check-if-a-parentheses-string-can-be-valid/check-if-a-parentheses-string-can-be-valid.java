class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n % 2 == 1) return false;

        Stack<Integer> open = new Stack<>();
        Stack<Integer> oc = new Stack<>();

        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            char l = locked.charAt(i);

            if(l == '0'){
                oc.push(i);
            }
            else if(ch == '(') open.push(i);
            else if(ch == ')'){
                if(!open.isEmpty()) open.pop();
                else if(!oc.isEmpty()) oc.pop();
                else return false;
            }
        }

        while(!open.isEmpty() && !oc.isEmpty() && oc.peek() > open.peek()){
            oc.pop();
            open.pop();
        }
        return open.isEmpty();
    }
}