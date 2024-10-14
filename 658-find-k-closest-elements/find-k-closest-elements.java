class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Integer> pq = new LinkedList<>();
        
        for(int no : arr){
            if(k-- > 0){
                pq.add(no);
            }
            else if(Math.abs(pq.peek() - x) > Math.abs(no - x)){
                pq.poll();
                pq.add(no);
            }
            
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            int no = pq.poll();
            ans.add(no);
        }
        return ans;
    }
}