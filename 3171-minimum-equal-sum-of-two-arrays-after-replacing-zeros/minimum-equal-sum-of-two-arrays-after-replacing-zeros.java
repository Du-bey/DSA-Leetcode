class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        long s1 = 0;
        long s2 = 0;

        int z1 = 0;
        int z2 = 0;

        for(int x : nums1){
            s1 += x;
            if(x == 0) z1++;
        }
        for(int x : nums2){
            s2 += x;
            if(x == 0) z2++;
        }
        
        if(z1 == 0 && s1 < s2 + z2) return -1;
        if(z2 == 0 && z1 + s1 > s2) return -1;

        return Math.max(s1 + z1, s2 + z2);
    }
}