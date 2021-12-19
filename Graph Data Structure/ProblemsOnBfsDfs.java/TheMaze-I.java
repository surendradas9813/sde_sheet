public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        Queue<Pair> q = new LinkedList<>();

        int row = maze.length;
        int col = maze[0].length;

        q.add(new Pair(start[0],start[1]));

        maze[start[0]][start[1]] = Integer.MAX_VALUE;

        int direction[][] = {{0,1},{1,0},{0,-1},{-1,0}};

        while(!q.isEmpty()){

            Pair popped = q.poll();

            int x = popped.x;
            int y = popped.y;

            System.out.println(x+" "+y);

            if(x == destination[0] && y == destination[1]) return true;



            for(int dir[] : direction){

                int newX = x;
                int newY = y;

                

                while(newX >= 0 && newY>=0 && newX<row && newY <col && maze[newX][newY] != 1){
                    newX += dir[0];
                    newY += dir[1];
                }

                newX -= dir[0];
                newY -= dir[1];

                if(maze[newX][newY] != Integer.MAX_VALUE){
                    maze[newX][newY] = Integer.MAX_VALUE;
                    q.add(new Pair(newX,newY));
                }
            }
        }

        return false;
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