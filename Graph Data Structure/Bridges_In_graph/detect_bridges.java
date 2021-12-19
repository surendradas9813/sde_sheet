import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		
		//1-based graph
		int V = sc.nextInt();
		int e = sc.nextInt();

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for(int i=0; i<=V; i++){
			adj.add(new ArrayList<>());
		}

		for(int i=1; i<=e; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();

			//udirected graph
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		boolean isVis[] = new boolean[V+1];

		//this stores the time at which we touch that node
		int tin[] = new int[V+1];

		//this stores the lowest time among all its adjacent 
		int lowT[] = new int[V+1];

		int count = 1;

		bridges(adj,isVis,1,-1,count,tin,lowT);

	}

	public static void bridges(ArrayList<ArrayList<Integer>> adj, boolean isVis[], int source, int parent,int count,int tin[], int lowT[]){
		
		isVis[source] = true;

		tin[source] = count++;
		lowT[source] = tin[source];

		for(int adjacent: adj.get(source)){

			//if it is the parent nothing to do
			if(parent == adjacent)
					continue;
			

			//if it is not visited we run dfs and check whether it is bridge while returning
			if(isVis[adjacent] == false){
				bridges(adj,isVis,adjacent,source,count,tin,lowT);

				lowT[source] = Math.min(lowT[source],lowT[adjacent]);  //make sure to update the lowtime of current node after returning

				if(tin[source] < lowT[adjacent])  //if intime is smaller than the lowtime of adjacent that means we cant reach adjacent by back path hence it is a bridge
					System.out.println(source+"----"+adjacent);	

			}
			else{
				//if it is already visited we update the low of current node
				lowT[source] = Math.min(lowT[source],lowT[adjacent]);	
			}
		}
	}

}