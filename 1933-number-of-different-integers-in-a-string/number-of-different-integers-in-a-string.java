class Solution {
    public int numDifferentIntegers(String word) {
        String replaced = word.replaceAll("[a-z]", " ");
        Set<String> nums = new HashSet();
        String [] words = replaced.split(" ");
        for (String s : words) {
            if (s.trim().length() > 0)
                nums.add(s.replaceAll("^0*", ""));
        }
        return nums.size();
    }
}