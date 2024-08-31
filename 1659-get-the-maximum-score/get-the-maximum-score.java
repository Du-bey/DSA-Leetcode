class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        long res = 0;
        int i = 0;
        int j = 0;
        long s1 = 0;
        long s2 = 0;
        long mod = (long) 1e9+7;
        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                s1 += nums1[i++];
            }
            else if(nums1[i] > nums2[j]){
                s2 += nums2[j++];
            }
            else{
                res += Math.max(s1, s2) + nums1[i];
                s1 = 0;
                s2 = 0;
                i++;
                j++;
            }
        }

        while(i < n){
            s1 += nums1[i++];
        }

        while(j < m){
            s2 += nums2[j++];
        }
        return (int)((res + Math.max(s1, s2)) % 1000000007);
    }
}