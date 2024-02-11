class Solution {
    public int minCostConnectPoints(int[][] points) {
        Set<Tuple> set = new HashSet<>();
        PriorityQueue<Tuple> queue = new PriorityQueue<>((t1,t2) -> t1.dist - t2.dist);

        int n = points.length;
        if(n == 0) return 0;

        set.add(new Tuple(points[0][0],points[0][1],0));
        queue.offer(new Tuple(points[0][0],points[0][1],0));

        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            if(!set.contains(t)) set.add(t);
            if(set.size() == n) break;
            
            int x = t.x;
            int y = t.y;
            int dist = t.dist;

            for(int i=0;i<n;i++){
                int[] point = points[i];
                int newDist = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                Tuple newT = new Tuple(point[0],point[1],newDist);
                if(!set.contains(newT)){
                    queue.offer(newT);
                }
            }
        }

        int totalEffort = 0;
        for(Tuple t : set){
            totalEffort += t.dist;
        }

        return totalEffort;
    }
    private class Tuple{
        int x;
        int y;
        int dist;
        public Tuple(int x,int y,int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return x == tuple.x && y == tuple.y; 
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

