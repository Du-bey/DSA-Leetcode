class Solution {

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int n = pairs.length;

        HashMap<Integer, Integer> in = new HashMap<>();
        HashMap<Integer, Integer> out = new HashMap<>();

        for(int[] r : pairs){
            int u = r[0];
            int v = r[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            in.put(v, in.getOrDefault(v, 0) + 1);
            out.put(u, out.getOrDefault(u, 0) + 1);
        }

        int start = pairs[0][0];
        for(int x : out.keySet()){
            if(out.get(x) - in.getOrDefault(x, 0) == 1){
                start = x;
                break;
            }
        }
        List<Integer> eulerPath = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int curr = stack.peek();
            if (adj.containsKey(curr) && !adj.get(curr).isEmpty()) {
                int neighbor = adj.get(curr).remove(adj.get(curr).size() - 1);
                stack.push(neighbor);
            } else {
                eulerPath.add(curr);
                stack.pop();
            }
        }

        int[][] ans = new int[n][2];
        Collections.reverse(eulerPath);
        for(int i =0;i<eulerPath.size() - 1;i++){
            ans[i][0] = eulerPath.get(i);
            ans[i][1] = eulerPath.get(i+1);
        }
        return ans;
    }
}