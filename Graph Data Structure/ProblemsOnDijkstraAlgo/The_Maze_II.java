public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        
        int row = maze.length;
        int col =  maze[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.w - b.w);

        //here for distance instead of creating 2d matrix we are goind with 1d by name 0,1,2...row*col-1 indices  which can written as (i*col+j) to represent 2d into 1d
        int dist[] = new int[row*col];
        Arrays.fill(dist,Integer.MAX_VALUE);

        pq.add(new Pair(start[0],start[1],0));

        dist[start[0]*col+start[1]] = 0;

        int direction[][] = {{0,1},{1,0},{0,-1},{-1,0}};

        while(!pq.isEmpty()){

            Pair popped = pq.poll();
            int x = popped.x;
            int y = popped.y;
            int w = popped.w;


            // if we reach the destination return weight because no need to go further
            if(x == destination[0] && y == destination[1]) return w;

            for(int dir[] : direction){
                int newX = x;
                int newY = y;

                int count = 0;

                while(newX >= 0 && newY >= 0 && newX < row && newY < col && maze[newX][newY] == 0){
                    newX += dir[0];
                    newY += dir[1];

                    count++;
                }

                //we reach out of condition so we have to reduce one
                newX -= dir[0];
                newY -= dir[1];
                count--;

                if(w+count < dist[newX*col+newY]){
                    dist[newX*col+newY] = w+count;
                    pq.add(new Pair(newX,newY,w+count));
                }
            }

        }

        if(dist[destination[0]*col+destination[1]] == Integer.MAX_VALUE) return -1; 

        else return dist[destination[0]*col+destination[1]];
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