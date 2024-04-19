class Solution {
    public int[][] merge(int[][] nums) {
        Comparator<int[]> customComparator = Comparator.comparingInt(arr -> arr[0]);

        Arrays.sort(nums, customComparator);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i =0;i<n;i++){
            int a = nums[i][0];
            int b = nums[i][1];

            while(i < n-1 && b >= nums[i+1][0]){
                if(b < nums[i+1][1]){
                    b = nums[i+1][1];
                }
                i++;
            }
            ans.add(Arrays.asList( a, b));
        }

        int rows = ans.size();
        int[][] array2D = new int[rows][2];

        for (int i = 0; i < rows; i++) {
            List<Integer> row = ans.get(i);
            for (int j = 0; j < 2; j++) {
                array2D[i][j] = row.get(j);
            }
        }
        return array2D;
    }

}