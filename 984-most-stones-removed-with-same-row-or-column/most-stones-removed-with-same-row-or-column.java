class Solution {
    public int removeStones(int[][] stones) {
        if(stones == null || stones.length == 0) return 0;
        
        final int N = stones.length;
        
        int count = 0;
        Set<Integer> visited = new HashSet<Integer>();
        for(int i = 0; i < N; i++){
            if(visited.contains(i)) continue;
            count++;
            dfs(stones, visited, i);
        }
        
        return N - count;
    }
    
    private void dfs(int[][] stones, Set<Integer> visited, int index){
        visited.add(index);
        for(int i = 0; i < stones.length; i++){
            
            if((stones[i][0] == stones[index][0] || stones[i][1] == stones[index][1]) && !visited.contains(i)){
                dfs(stones, visited, i);
            }
        }
    }
}