class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        
        //The question simply boils down into detecting the cycle in the given prerequisites array or try to generate the toposort
        //if we are possible to generate toposort then the answer is true there is no cycle because toposort is only possible fo DAG
        
        
        //Here we are using dfs to detect cycle
        //we can also use bfs kahn algo here.
        
        int V = numCourses;
        
        //creating adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<V; i++)
            adj.add(new ArrayList<>());
        
        for(int item[] : prerequisites){
            adj.get(item[1]).add(item[0]);
        }
        
        boolean isVis[] = new boolean[V];
        boolean dfsVis[] = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(isVis[i] == false){
                
                //if cycle is present we return false 
                if(dfs(isVis,dfsVis,adj,i)) return false;
            }
        }
        return true;
    }
    
    public boolean dfs(boolean isVis[], boolean dfsVis[], ArrayList<ArrayList<Integer>> adj,int source){
        
        isVis[source] = true;
        dfsVis[source] = true;
        
        for(int adjacent: adj.get(source)){
            
            if(isVis[adjacent] == false){
                if(dfs(isVis,dfsVis,adj,adjacent)) return true;
            }
            
            else if(dfsVis[adjacent] == true)
                return true;
        }
        dfsVis[source] = false;
        return false;
    }
}