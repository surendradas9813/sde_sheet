class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        
        //Here we have to go through each and every path so better use dfs with backtrack
        
        boolean isVis[] = new boolean[graph.length];
        
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(0,isVis,result,new ArrayList<>(),graph);
        
        return result;
    }
    
    
    public void dfs(int source, boolean[] isVis, List<List<Integer>> result, List<Integer> temp,int graph[][]){
        
        
        
        temp.add(source);
        isVis[source] = true;
        
        if(source == graph.length-1){
            result.add(new ArrayList<>(temp)); // we have to create new and add because of pass by reference
            
            //backtrack
            isVis[source] = false;
            temp.remove(temp.size()-1);
            
            return;
        }
        
        for(int adjacent: graph[source]){
            
            if(isVis[adjacent] == false){
                dfs(adjacent,isVis,result,temp,graph);
            }
        }
        
        //backtrack
        isVis[source] = false;
        temp.remove(temp.size()-1);
        
    }
}