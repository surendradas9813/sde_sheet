class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        //here we need to generate topoSort
        // Either we can use kahn algo or dfs to produce topoSort
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++)
            adj.add(new ArrayList<>());
        
        for(int item[] : prerequisites){
            adj.get(item[1]).add(item[0]);
        }
        
        int indegrees[] = new int[numCourses];
        
        for(int i=0; i<numCourses; i++){
            for(int adjacent: adj.get(i))
                indegrees[adjacent]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++){
            if(indegrees[i] == 0 )
                q.add(i);
        }
        
        int count = 0;
        int result[] = new int[numCourses];
        
        while(!q.isEmpty()){
            int popped = q.poll();
            result[count++] = popped;
            
            for(int adjacent: adj.get(popped)){
                indegrees[adjacent]--;
                
                if(indegrees[adjacent] == 0)
                    q.add(adjacent);
            }
        }
        
        if(count != numCourses) return new int[]{};
        
        else return result;
        
    }
}