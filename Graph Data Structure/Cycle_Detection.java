//Undirected Graph

//BFS solution
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean isVis[] = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(isVis[i] == false){
                if(bfs(i,adj,isVis)) return true;
            }
        }
        
        return false;
    }
    
    
    public boolean bfs(int source, ArrayList<ArrayList<Integer>> adj, boolean isVis[]){
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(source,-1));
        isVis[source] = true;
        
        while(!q.isEmpty()){
            
            Pair popped = q.poll();
            
            int node = popped.node;
            
            int parent = popped.parent;
            
            for(int adjacent: adj.get(node)){
                
                if(isVis[adjacent] == false){
                    q.add(new Pair(adjacent,node));
                    isVis[adjacent] = true;
                }
                
                else if(adjacent != parent) return true;
            }
        }
        
        return false;
    }
}


class Pair{
    int node;
    int parent;
    
    Pair(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}




//DFS solution
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean isVis[] = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(isVis[i] == false){
                if(dfs(i,-1,adj,isVis) == true) return true;
            }
        }
        
        return false;
    }
    
    
    public boolean dfs(int source, int parent, ArrayList<ArrayList<Integer>> adj, boolean isVis[]){
        
        isVis[source] = true;
        
        for(int adjacent: adj.get(source)){
            
            if(isVis[adjacent] == false){
                
                if(dfs(adjacent,source, adj,isVis)) return true;
                
            }
            else if(adjacent != parent) return true;
        }
        
        return false;
    }
}





//Directed Graph
//Incase of directed the above logic fails here we have to maintain another array for considering the particular path and again marking false while backtracking


//dfs solution
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean isVis[] = new boolean[V];
        boolean dfsVis[] = new boolean[V];
        
        for(int i=0; i<V; i++){
            
            if(isVis[i] == false){
                
                if(dfs(i,adj,isVis,dfsVis)) return true;
            }
        }
        
        return false;
    }
    
    
    public  boolean dfs(int source, ArrayList<ArrayList<Integer>> adj, boolean isVis[], boolean dfsVis[]){
        
        isVis[source] = true;
        dfsVis[source] = true;
        
        for(int adjacent : adj.get(source)){
            
            if(isVis[adjacent] == false){
                if(dfs(adjacent,adj,isVis,dfsVis))
                    return true;
            }
            
            else if(dfsVis[adjacent] == true)
                return true;
        }
        
        dfsVis[source] = false;
        
        return false;
    }
}




//BFS solution
// we need to use kahn algo and check if we are able to generate toposort or not because toposort can be generated only in DAG.

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
       int indegrees[] = new int[V];
       
       //maintaining indegrees value for all nodes
       for(int i=0; i<V; i++){
           for(int adjacent: adj.get(i))
                indegrees[adjacent]++;
       }
       
       Queue<Integer> q = new LinkedList<>();
       
       //initially pushing to the queue whose indegrees is zero
       
       for(int i=0; i<V; i++){
           if(indegrees[i] == 0)
            q.add(i);
       }
       
       int count = 0;
       
       while(!q.isEmpty()){
           
           int popped = q.poll();
           
           count++;
           
           for(int adjacent: adj.get(popped)){
               
               //reducint the indegrees value of adjacent element if it reaches to zero then push to the queue.
               indegrees[adjacent]--;
               
               if(indegrees[adjacent] == 0)
                    q.add(adjacent);
           }
       }
       
       if(count == V) return false;
       else return true;
       
    }
}
