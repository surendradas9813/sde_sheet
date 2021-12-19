import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		
		//0-based graph
		int V = sc.nextInt();
		int e = sc.nextInt();

		ArrayList<Pair> ar = new ArrayList<>();

		for(int i=1; i<=e; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();

			ar.add(new Pair(u,v,w));
		}

		kruskalAlgo(ar,V);

	}

// Time complexity -> O(M log M) for sorting and O(M * 4alpha for dsu operation)  ---> O(MLogM) time
	public static void kruskalAlgo(ArrayList<Pair> arr, int V){

		//sorting the arr on the increasing order of edge weights
		Collections.sort(arr,(a,b)->a.w-b.w);

		//creating object of DSU
		DSU dsu = new DSU(V);

		int mstWeight = 0;

		//mst
		ArrayList<Pair> mst = new ArrayList<>();

		for(Pair item: arr){

			int u = item.u;
			int v = item.v;
			int w = item.w;

			//if their parent is same then we can add in mst
			if(dsu.findPar(u) != dsu.findPar(v)){
				dsu.union(u,v);  //we make their ultimate parent same by doing union
				mst.add(item);  // adding the edge to mst
				mstWeight += w;  //adding the weight for final mst weight
			}
		}

		System.out.println("Printing the edges");
		for(Pair item: mst)
			System.out.println(item.u+" "+item.v);

		
		System.out.println(mstWeight);
	}

	
}

class Pair{
	int u;
	int v;
	int w;

	Pair(int u,int v,int w){
		this.u = u;
		this.v = v;
		this.w = w;
	}
}


class DSU{

	private int[] parent, size;

	DSU(int n){
		parent = new int[n+1];
		size = new int[n+1];

		//1 base indexing
		for(int i=0; i<=n; i++){
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