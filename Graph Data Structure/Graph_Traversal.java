//These graph traversal techniques are applicable for all kind of directed undirected graph.
//Time complexity -> O(v+E)  ---> O(n)(for disconnect graph checking each node and runnding traversal) +O(n)(for outer loop) +O(2M)(for visiting ajdacent nodes)

//BFS (holds valid for disconnected graph as well)

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean isVis[] = new boolean[V];
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            
           if(isVis[i] == false){
                bfs(i,isVis,adj,result);
            }
        }
        
        return result;
    }
    
    
    public void bfs(int source, boolean isVis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result){
        
        Queue<Integer> q = new LinkedList<>();
        
        isVis[source] = true;
        q.add(source);
        
        
        while(!q.isEmpty()){
            
            int popped = q.poll();
            
            result.add(popped);
            
            for(int adjacent: adj.get(popped)){
                
                if(isVis[adjacent] == false){
                    
                    isVis[adjacent] = true;
                    q.add(adjacent);
                }
            }
        }
    }
}





//DFS(holds valid for disconnected graph as well)

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean isVis[] = new boolean[V];
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            
            if(isVis[i] == false)
                dfs(i,isVis,adj,result);
        }
        
        return result;
    }
    
    public void dfs(int source, boolean isVis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result){
        
        result.add(source);
        isVis[source] = true;
        
        for(int adjacent: adj.get(source)){
            if(isVis[adjacent] == false)
                dfs(adjacent,isVis,adj,result);
        }
    }
}