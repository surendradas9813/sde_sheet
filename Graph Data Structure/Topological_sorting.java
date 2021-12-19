//Two methods are there for topological sorting--->i) DFS method
//                                                 ii) BFS(Kahn algorithm)  
//
// Note---> topological sorting is only possible in directed acyclic graph(DAG)


//DFS solution
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean isVis[] = new boolean[V];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<V; i++){
            
            if(isVis[i] == false){
                dfs(i,isVis,adj,st);
            }
        }
        
        int result[] = new int[V];
        int ind = 0;
        
        while(!st.isEmpty()){
            
            result[ind++] = st.pop();
        }
        
        return result;
    }
    
    static void dfs(int source, boolean isVis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        
        isVis[source] = true;
        
        for(int adjacent: adj.get(source)){
            
            if(isVis[adjacent] == false)
                dfs(adjacent,isVis,adj,st);
        }
        
        st.push(source);
    }
}



//BFS solution(Kahn algo)
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
       
       int indegree[] = new int[V];
       
       for(int i=0; i<V; i++){
           for(int adjacent: adj.get(i))
            indegree[adjacent]++;
       }
       
       Queue<Integer> q = new LinkedList<>();
       
       for(int i=0; i<V; i++){
           if(indegree[i] == 0)
                q.add(i);
       }
       
       int result[] = new int[V];
       int ind = 0;
       
       while(!q.isEmpty()){
           
           int popped = q.poll();
           result[ind++] = popped;
           
           for(int adjacent: adj.get(popped)){
               
               indegree[adjacent]--;
               
               if(indegree[adjacent] == 0)
                    q.add(adjacent);
           }
       }
       
       return result;
    }
}
