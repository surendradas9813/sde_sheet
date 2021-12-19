class Solution {
    public int numIslands(char[][] grid) {
        
        //We can use either dfs or bfs.
        //Logic is to find how many connected components are there in the given matrix so any of the traversal menthod will work
        
        int row = grid.length;
        int col = grid[0].length;
        
        int count = 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(i,j,grid,row,col);
                }
            }
        }
        return count;
    }
    
    public void bfs(int x, int y, char grid[][], int row, int col){
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(x,y));
        grid[x][y] = '0';
        
        int direction[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        
        while(!q.isEmpty()){
            
            Pair popped = q.poll();
            
            int currX = popped.x;
            int currY = popped.y;
            
            for(int dir[] : direction){
                
                int newX = currX+dir[0];
                int newY = currY+dir[1];
                
                if(newX >= 0 && newY >= 0 && newX < row && newY < col && grid[newX][newY] == '1'){
                    
                    grid[newX][newY] = 0;
                    q.add(new Pair(newX,newY));
                }
            }
        }
    }
}

class Pair{
    int x;
    int y;
    
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}




//DFS solution
class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int count = 0;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                
                if(grid[i][j] == '1'){
                    solve(grid,i,j);
                    count++;
                }
            }
        }
        return count;   
    }
    
    public void solve(char grid[][], int i, int j){
        
        grid[i][j] = '0';
        
        int points[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        
        for(int point[]:points){
            
            int x = i+point[0];
            int y = j+point[1];
            
            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y] == '1')
                solve(grid,x,y);
        }
        
        
    }
    
}