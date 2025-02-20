class Solution {
    int n;
    Map<Character, String> keyboard;
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()) return new ArrayList<>();
        n = digits.length();
        List<String> ans = new ArrayList<>();
        String s = "";
        keyboard = new HashMap<>();
        keyboard.put('2', "abc");
        keyboard.put('3', "def");
        keyboard.put('4', "ghi");
        keyboard.put('5', "jkl");
        keyboard.put('6', "mno");
        keyboard.put('7', "pqrs");
        keyboard.put('8', "tuv");
        keyboard.put('9', "wxyz");
        solve(0, s, ans, digits);
        return ans;
    }

    public void solve(int i, String s, List<String> ans, String digits){
        if(s.length() == n){
            ans.add(s);
            return;
        }

        String value = keyboard.get(digits.charAt(i));
        for(int j =0;j<value.length();j++){
            solve(i+1, s + value.charAt(j), ans, digits);
        }
    }
}