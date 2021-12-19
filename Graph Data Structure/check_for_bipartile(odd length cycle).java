//if the graph can be coloured using 2 colors such that no two adjacent nodes have same color then it is called bipartile graph.
//The graph with odd length cycle is not bipartile graph


//DFS solution
class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[] = new int[V];
        Arrays.fill(color,-1);
        
        for(int i=0; i<V; i++){
            
            if(color[i] == -1)
                if(dfs(i,color,adj) == false) return false;
        }
        
        return true;
    }
    
    public boolean dfs(int source, int color[], ArrayList<ArrayList<Integer>> adj){
        
        if(color[source] == -1) color[source] = 1;
        
        for(int adjacent: adj.get(source)){
            
            if(color[adjacent] == -1){
                
                color[adjacent] = 1- color[source];
                if(dfs(adjacent,color,adj) == false) return false;
            }
            
            else if(color[adjacent] == color[source])
                return false;
        }
        return true;
    }
}





//BFS solution
class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[] = new int[V];
        Arrays.fill(color,-1);
        
        for(int i=0; i<V; i++){
            
            if(color[i] == -1)
                if(bfs(i,color,adj) == false) return false;
        }
        
        return true;
    }
    
    public boolean bfs(int source, int color[], ArrayList<ArrayList<Integer>> adj){
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(source);
        color[source] = 1;
        
        while(!q.isEmpty()){
            
            int popped = q.poll();
            
            for(int adjacent: adj.get(popped)){
                
                if(color[adjacent] == -1){
                    
                    color[adjacent] = 1-color[popped];
                    q.add(adjacent);
                }
                
                else if(color[adjacent] == color[popped])
                    return false;
            }
        }
        
        return true;
    }
}
