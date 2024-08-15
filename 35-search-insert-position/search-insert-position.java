class Solution {
    public int searchInsert(int[] arr, int x) {
        int n = arr.length;
        int l = 0;
		int h = n-1;
		int ans = n;
		while(l <= h){
			int m = (l+h)/2;
			if(arr[m] == x){
				ans = m;
				break;
			}
			else if(arr[m] > x){
                ans = m;
				h = m - 1;
				
			}
			else{
				l = m + 1;
			}
		}
		return ans;
    }
}