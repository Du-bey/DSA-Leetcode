class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int dif = arr[n-1] - arr[0];

        for(int i = 0;i<n-1;i++){
            dif = Math.min(arr[i+1] - arr[i], dif);
        }

        for(int i = 0;i<n-1;i++){
            if(arr[i+1] - arr[i] == dif){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                ans.add(temp);
            }
        }
        return ans;
    }
}