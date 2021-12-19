//Union by size DSU
//1 based indexing DSU but this will work for both 0-based and 1-based indexing

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