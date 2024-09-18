class Solution {
    public String largestNumber(int[] nums) {
        List<String> l = new ArrayList<>();
        for(int x : nums){
            l.add(String.valueOf(x));
        }
        Collections.sort(l, (a, b) -> compare(a, b));
        String ans = String.join("", l);
        if(ans.charAt(0) == '0') return "0";
        return ans;
    }

    private int compare(String a, String b){
        String s1 = a + b;
        String s2 = b + a;
        return s2.compareTo(s1);
    }
}