
class solve 
{
    //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) 
    {
        
        //Time Complexity --> N^m
        //space complexity --> O(n) for recurison
        
        //Idea is to try out all possible ways using recursion and backtraking and if possible we return true and stop the whole recursion tree
        int n = G.length;
        
        if(solve(G,n,color,i,C) == true) return true;
        
        return false;
    }
    
    
    public static boolean solve(List<Integer>[] G, int size, int color[], int node, int c){
        if(node == size )
            return true;
            
        for(int i=1; i<=c; i++){
            if(isPossible(G,node,i,color)){
                
                color[node] = i;
                
                if(solve(G,size,color,node+1,c) == true) return true;
                
                color[node] = 0;
            }
        }
        
        return false;
    }
    
    public static boolean isPossible(List<Integer>[] G, int node, int col, int color[]){
        
        for(int adjacent: G[node]){
            if(color[adjacent] == col)
                return false;
        }
        return true;
    }
}