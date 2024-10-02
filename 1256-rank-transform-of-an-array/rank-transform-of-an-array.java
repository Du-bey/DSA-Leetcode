class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> h = new HashMap<>();
        
        int[] a = Arrays.copyOf(arr, arr.length);
        Arrays.sort(a);
        for(int x : a){
            h.putIfAbsent(x, h.size() + 1);
        }
        for(int i =0;i<arr.length;i++){
            a[i] = h.get(arr[i]);
        }
        return a;
    }
}