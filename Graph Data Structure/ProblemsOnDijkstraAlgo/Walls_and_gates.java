class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {

        int row = rooms.length;
        int col = rooms[0].length;


        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){

                if(rooms[i][j] == 0)
                    q.add(new Pair(i,j,0));
            }
        }

        int direction[][] = {{0,1},{1,0},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            Pair popped = q.poll();
            int x = popped.x;
            int y = popped.y;

            int w = popped.w;

            for(int dir[] : direction){
                
                int newX = x+dir[0];
                int newY = y+dir[1];

                if(newX >= 0 && newY >= 0 && newX < row && newY < col && rooms[newX][newY] > 0 && w+1 < rooms[newX][newY]){

                    rooms[newX][newY] = w+1;

                    q.add(new Pair(newX,newY,w+1));
                }
            }

        }
        
    }
}

class Pair{
    int x;
    int y;
    int w;

    Pair(int x, int y, int w){
        this.x = x;
        this.y = y;
        this.w = w;
    }
}