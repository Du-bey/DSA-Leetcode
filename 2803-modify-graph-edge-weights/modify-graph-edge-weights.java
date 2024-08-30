class Solution {
    private static final int LARGE_VALUE = (int) 2e9;
    public int[][] modifiedGraphEdges(int n, int[][] edges, int s, int des, int t) {
        long currShortestDist = dijkstraAlgo(n, edges, s, des);

        if (currShortestDist < t) {
            return new int[0][];
        }

        boolean matchedTarget = (currShortestDist == t);
        for (int[] edge : edges) {
            if (edge[2] == -1) {
                edge[2] = matchedTarget ? LARGE_VALUE : 1; 

                if (!matchedTarget) {
                    long newShortestDist = dijkstraAlgo(n, edges, s, des);

                    if (newShortestDist <= t) {
                        matchedTarget = true;
                        edge[2] += (t - newShortestDist); 
                    }
                }
            }
        }

        if (!matchedTarget) {
            return new int[0][];
        }
        return edges;
    }

    public long dijkstraAlgo(int n, int[][] edges, int src, int dest){
        Map<Long, List<long[]>> adj = new HashMap<>();
        for (int[] edge : edges) {
            if (edge[2] != -1) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                adj.computeIfAbsent((long) u, k -> new ArrayList<>()).add(new long[]{v, wt});
                adj.computeIfAbsent((long) v, k -> new ArrayList<>()).add(new long[]{u, wt});
            }
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long[] result = new long[n]; 
        boolean[] visited = new boolean[n];
        Arrays.fill(result, Long.MAX_VALUE);
        result[src] = 0;
        pq.offer(new long[]{0, src});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currDist = curr[0];
            int currNode = (int) curr[1];

            if (visited[currNode]) continue;
            visited[currNode] = true;

            if (!adj.containsKey((long) currNode)) continue;

            for (long[] neighbor : adj.get((long) currNode)) {
                int nbr = (int) neighbor[0];
                long weight = neighbor[1];

                if (result[nbr] > currDist + weight) {
                    result[nbr] = currDist + weight;
                    pq.offer(new long[]{result[nbr], nbr});
                }
            }
        }

        return result[dest];
    }
}

class Pair{
    long d;
    long node;
    public Pair(long d, long node){
        this.d = d;
        this.node = node;
    }
}