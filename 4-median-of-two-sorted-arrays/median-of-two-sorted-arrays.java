class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if(n > m) return findMedianSortedArrays(nums2, nums1);
        int tSize = n + m, left = (n+m+1)/2;
        boolean isEven = tSize % 2 == 0;
        int l = 0, h = n;
        while(l <= h){
            int mid = (l+h) / 2;
            int mid2 = left - mid;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(mid > 0) l1 = nums1[mid-1];
            if(mid2 > 0) l2 = nums2[mid2-1];
            if(mid < n) r1 = nums1[mid];
            if(mid2 < m) r2 = nums2[mid2];
            if((l1 <= r2) && (l2 <= r1)){
                if(isEven){
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
                else{
                    return Math.max(l1, l2);
                }
            }
            else if(l1 < r2){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        return -1;
    }
}