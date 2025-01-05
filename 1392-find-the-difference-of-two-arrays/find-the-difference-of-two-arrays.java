class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> h1 = new HashSet<>();
        HashSet<Integer> h2 = new HashSet<>();
        HashSet<Integer> h3 = new HashSet<>();
        HashSet<Integer> h4 = new HashSet<>();

        for(int x : nums1) h1.add(x);
        for(int x : nums2) h2.add(x);

        for(int x : nums1){
            if(!h2.contains(x)) h3.add(x);
        }
        for(int x : nums2){
            if(!h1.contains(x)) h4.add(x);
        }
        List<Integer> l1 = new ArrayList<>(h3);
        List<Integer> l2 = new ArrayList<>(h4);
        ans.add(l1);
        ans.add(l2);
        return ans;
    }
}