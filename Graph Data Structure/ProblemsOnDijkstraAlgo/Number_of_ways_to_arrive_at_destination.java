class Solution {
    public int countPaths(int n, int[][] roads) {
        
        //to count the total no of paths we have to maintain an extra array which says how many ways are there to reach ith node in shortest distance
        
        //we go on calculating shortest distance in dist[] and if we encounter the new dist to be equal as stored previously that means that node can be
        // reached in one more ways in  same shortest distance so we update the ways[] to current ways+ ways from which we visited the current node.
        
        
        //creating adjacency List
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++){  //0-based indexing graph
            adj.add(new ArrayList<Pair>());
        }
        
        for(int road[] : roads){
            
            //grahp in undirected
            int u = road[0];
            int v = road[1];
            long w = road[2];
            
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        long dist[] = new long[n+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        
        int ways[] = new int[n+1];
        
        dijkstra(ways,dist,adj,0);
        
        return ways[n-1];
        
    }
    
    public void dijkstra(int ways[],long dist[], ArrayList<ArrayList<Pair>> adj,int source){
        
        int mod = 1000000007;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.weight > b.weight)
                return 1;
            else return -1;
        });
        
        pq.add(new Pair(0,0));
        ways[0] = 1;
        dist[0]  = 0;
        
        while(!pq.isEmpty()){
            Pair popped = pq.poll();
            
            int node = popped.node;
            long weight = popped.weight;
            
            for(Pair adjacent: adj.get(node)){
                
                int adjNode = adjacent.node;
                long adjWeight = adjacent.weight;
                
                if(adjWeight+weight < dist[adjNode]){
                    
                    dist[adjNode] = adjWeight+weight;   //updating dist array
                    ways[adjNode] = ways[node];  // the ways for new node is equal to ways of previous node for this shortest path
                    pq.add(new Pair(adjNode,dist[adjNode]));
                }
                
                else if(adjWeight+weight == dist[adjNode]){    //this means if we have already visited the same node with same shorter distance  then we have to add the ways of previous and the                                                                         //adjacent for adjacent 
                    ways[adjNode] = (ways[adjNode]+ways[node])%mod;
                }
            }
        }
    }
}


class Pair{
    int node;
    long weight;
    
    Pair(int node, long weight){
        this.node = node;
        this.weight = weight;
    }
}