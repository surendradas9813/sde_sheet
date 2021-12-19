//There is one more problem names as Wall and Gates (premium problem) can be seen on lintcode


class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<Pair> q = new LinkedList<>();
        
        int row = grid.length;
        int col = grid[0].length;
        
        //This variable to count the total no of oranges so that at last we check all the oranges are rotten or not
        int count = 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                }
                
                if(grid[i][j] != 0)
                    count++;
            }
        }
        
        int result = 0;
        
        int direction[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        
        while(!q.isEmpty()){
            
            Pair popped = q.poll();
            
            int x = popped.x;
            int y = popped.y;
            int t = popped.t;
            
            count--;
            
            result = t;
            
            for(int dir[] : direction){
                
                int newX = x+dir[0];
                int newY = y+dir[1];
                
                if(newX >=0 && newY >= 0 && newX < row && newY < col && grid[newX][newY] == 1){
                    
                    grid[newX][newY] = 2;  //rotting the oranges
                    q.add(new Pair(newX,newY,t+1));
                }
            }
        }
        
        if(count == 0) return result;
        else return -1;
    }
}

class Pair{
    int x;
    int y;
    int t;
    
    Pair(int x, int y, int t){
        this.x = x;
        this.y = y;
        this.t = t;
    }
}