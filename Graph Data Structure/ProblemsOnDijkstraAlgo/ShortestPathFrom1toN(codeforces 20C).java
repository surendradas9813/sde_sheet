import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inp1[] = br.readLine().trim().split(" ");

		int V = Integer.parseInt(inp1[0]);

		int e = Integer.parseInt(inp1[1]);

		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

		for(int i=0; i<=V; i++){
			adj.add(new ArrayList<>());
		}

		for(int i=1; i<=e; i++){
			String inp2[] = br.readLine().trim().split(" ");

			int u = Integer.parseInt(inp2[0]);
			int v = Integer.parseInt(inp2[1]);
			long w = Long.parseLong(inp2[2]);

			adj.get(u).add(new Pair(v,w));
			adj.get(v).add(new Pair(u,w));
		}

		dijkstra(adj,V, 1);

	}

	public static void dijkstra(ArrayList<ArrayList<Pair>> adj, int V, int source){
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
			if(a.weight > b.weight)
				return 1;
			else
				return -1;
		});

		long dist[] = new long[V+1];
		Arrays.fill(dist,Long.MAX_VALUE);

		int parent[] = new int[V+1];
		Arrays.fill(parent,-1);

		pq.add(new Pair(source,0));
		
		dist[source] = 0;


		while(!pq.isEmpty()){
			Pair popped = pq.poll();

			int node = popped.node;
			long weight = popped.weight;

			for(Pair adjacent: adj.get(node)){

				int adjNode = adjacent.node;
				long adjWeight = adjacent.weight;

				if(adjWeight + weight < dist[adjNode]){

					dist[adjNode] = adjWeight+weight;  //updating distance
					parent[adjNode] = node;				// updating parent

					pq.add(new Pair(adjNode,dist[adjNode])); //adding to the queue
				}

			}
		}
		
		//if the node in not reachable
		if(parent[V] == -1){
			System.out.println("-1");
			return;
		}

		int destination = V;

		Stack<Integer> st = new Stack<>();

		//for finding the path from 1 to N
		while(destination != -1){
			st.push(destination);
			destination = parent[destination];
		}

		StringBuilder sb = new StringBuilder();

		while(!st.isEmpty()){
			sb.append(st.pop()+" ");
		}

		System.out.println(sb);
	}
}


class Pair{
	int node;
	long weight;

	Pair(int node, long weight){
		this.node = node;
		this.weight = weight;
	}
}