public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here

        int row = n;
        int col = m;

        DSU dsu = new DSU(n*m);

        int mat[][] = new int[row][col];

        List<Integer> result = new ArrayList<>();

        //edge case to be handled
        if(operators == null) return result;

        int count = 0;

        int direction[][] = {{0,1},{1,0},{-1,0},{0,-1}};

        for(Point pnt: operators){

            int x = pnt.x;
            int y = pnt.y;

            int ind1 =  x*col+(y+1);

            if(mat[x][y] == 1){
                result.add(count);
                continue;
            }

            mat[x][y] = 1;
            count++;

            for(int dir[] : direction){
                int newX = x+dir[0];
                int newY = y+dir[1];
                
                int ind2 = newX*col+(newY+1);


                //here we have to make sure that their parent is different else we may reduce the count if 1 1 1 1
                //                                                                                             * 1              
                //                                                                                               1
                //    * is the place where we have to make so this case should be handled                                                                                                
                if(newX >=0 && newY >= 0 && newX < row && newY < col && mat[newX][newY] == 1 && dsu.findPar(ind1) != dsu.findPar(ind2)){
                    count--;
                    dsu.union(ind1,ind2);
                }
            }

            result.add(count);
        }

        return result;
    }
}


class DSU{

	private int[] parent, size;

	DSU(int n){
		parent = new int[n+1];
		size = new int[n+1];

		//1 base indexing
		for(int i=1; i<=n; i++){
			parent[i] = i;
			size[i] = 1;
		}
	}

	public int findPar(int node){
		if(node == parent[node])
			return node;


		//path compressiog -> O(log n)
		//path compression -> O(4 X alpha)
		return parent[node] = findPar(parent[node]);
	}

	public void union(int u, int v){
		int pu = findPar(u);
		int pv = findPar(v);

		//if there parent is same nothing to do
		if(pu == pv)
			return;


		//Here we add the smaller component to larger to make the ds time efficient which is called union by size. 
		if(size[pu] < size[pv]){
			parent[pu] = pv;
			size[pv] += size[pu];
		}
		else{
			parent[pv] = pu;
			size[pu] += size[pv];
		}
	}
}