class Solution {
    public int snakesAndLadders(int[][] board) {
        // code here
        int n = board.length;
        int size = n*n;
        int[] moves = new int[size+1];
        Collections.reverse(Arrays.asList(board));
        int k = 1;
        for (int i =0; i<n; i++) {
            int j =0;
            int decrease = 0;
            if(i%2 != 0) {
                j = n-1;
                decrease = 1;
            }
            while(j>=0 && j<n){
                moves[k] = board[i][j];
                j = decrease == 0 ? j+1 : j-1;
                System.out.println(moves[k] + " k" + k);
                k++;
            }
           
        }
        boolean[] vis = new boolean[size+1];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0));
        vis[1] = true;
        int ans = 10000;
        
        while(!q.isEmpty()){
            int node = q.peek().first;
            int d = q.peek().second;
            q.remove();
            if(node == size && ans > d) {
                ans= d;
            }
            
            for(int i =node+1 ;i<= node +6 && i<=size; i++){
                int newNode = i;
                if(!vis[newNode]){
                    int newDis = d+1;
                    int nNode = (moves[newNode] == -1 ? newNode : moves[newNode]);
                    
                    vis[newNode] = true;
                    q.add(new Pair(nNode, newDis));
                }
                
            }
        }
        if(ans == 10000) ans = -1;
        return ans;
    }
}

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}