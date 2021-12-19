//shortest path in graph having unit weight edges   Time Complexity--> O(N+E) normal bfs solution

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		//motive it to calculate the shortest distance from given vertex to all other vertex in an array

		//taking the number of vertives 0-based
		int V = sc.nextInt();

		//no of edges
		int n = sc.nextInt();

		//creating the adjacency list
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for(int i=0; i<V; i++)
			adj.add(new ArrayList<>());

		for(int i=1; i<=n; i++){

			//since the graph has unit weight we can avoid taking the input of weight of edges
			int u = sc.nextInt();
			int v = sc.nextInt();

			//undirected graph
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		//calculating shortest from 0 to all other vertices
		shortestPath(adj,V,0);	
	}


	public static void shortestPath(ArrayList<ArrayList<Integer>> adj, int V, int source){
		
		Queue<Integer> q = new LinkedList<>();
		
		int dist[] = new int[V];
		Arrays.fill(dist,Integer.MAX_VALUE);
		
		dist[source] = 0;
		q.add(source);

		while(!q.isEmpty()){
			int popped = q.poll();

			for(int adjacent: adj.get(popped)){
				
				if(dist[popped]+1 < dist[adjacent]){
					dist[adjacent] = dist[popped]+1;
					q.add(adjacent);
				}
			}
		}
		System.out.println(Arrays.toString(dist));
	}
}



// 0/1 BFS algorithm for the graph having weights 0 and 1 or any other number but one weight should be 0 and another can be any.
//Here we deque data structure to optimize the solution although we can solve by using normal queue but to reduce the computation we prefer deque i.e. double ended queue
// for 0 weight edge we add in front and for 1 we add at last so that we maintain the order like {0....1....2.....3...} weight edges in deque
//Time complexity ----> O(N+E) normal bfs

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		//motive it to calculate the shortest distance from given vertex to all other vertex in an array

		//taking the number of vertives 1-based
		int V = sc.nextInt();

		//no of edges
		int n = sc.nextInt();

		//creating the adjacency list
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

		for(int i=0; i<=V; i++)
			adj.add(new ArrayList<Pair>());

		for(int i=1; i<=n; i++){

			//since the graph has either 0 or 1 weight we should take u v and w input
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();

			//undirected graph
			adj.get(u).add(new Pair(v,w));
			adj.get(v).add(new Pair(u,w));
		}

		//calculating shortest from 0 to all other vertices
		shortestPath(adj,V,1);	
	}


	public static void shortestPath(ArrayList<ArrayList<Pair>> adj, int V, int source){
		
		//Here we will use deque data structure so that when we encounter 0 weight we push to front and for 1 we push to end.
		Deque<Pair> dq = new LinkedList<>();
		
		int dist[] = new int[V+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		
		dist[source] = 0;
		dq.add(new Pair(source,0));

		while(!dq.isEmpty()){
			Pair popped = dq.poll();

			int node = popped.node;
			int weight = popped.weight;

			for(Pair adjacent: adj.get(node)){

				int adjNode = adjacent.node;
				int adjWeight = adjacent.weight;
				
				if(weight + adjWeight < dist[adjNode]){
					dist[adjNode] = weight+adjWeight;
					
					if(adjWeight == 0)
						dq.addFirst(new Pair(adjNode,dist[adjNode]));

					else
						dq.addLast(new Pair(adjNode,dist[adjNode]));
				}
			}
		}
		System.out.println(Arrays.toString(dist));
	}
}


class Pair{
	int node;
	int weight;

	Pair(int node, int weight){
		this.node = node;
		this.weight = weight;
	}
}






//Dijkstra algorithm ---> Time complexity (N+Elogn) time as priority queeu is used so logn factor increases
// used for variable weighted graphs.
//Normal queue can be also be used to solve the problem but by using priority queue the number of computation reduces as we consider the least weight first so the vertices wont be pushed twice if it can be reached twice from different paths as we consider shorter first.

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		//motive it to calculate the shortest distance from given vertex to all other vertex in an array

		//taking the number of vertives 1-based
		int V = sc.nextInt();

		//no of edges
		int n = sc.nextInt();

		//creating the adjacency list
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

		for(int i=0; i<=V; i++)
			adj.add(new ArrayList<Pair>());

		for(int i=1; i<=n; i++){

			//since the graph has variable weight we should take u v and w input
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();

			//undirected graph
			adj.get(u).add(new Pair(v,w));
			adj.get(v).add(new Pair(u,w));
		}

		//calculating shortest from 0 to all other vertices
		shortestPath(adj,V,1);	
	}


	public static void shortestPath(ArrayList<ArrayList<Pair>> adj, int V, int source){
		
		//Here we will dijkstra algo so priorty queue should be created
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);


		
		int dist[] = new int[V+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		
		dist[source] = 0;
		pq.add(new Pair(source,0));

		while(!pq.isEmpty()){
			Pair popped = pq.poll();

			int node = popped.node;
			int weight = popped.weight;

			for(Pair adjacent: adj.get(node)){

				int adjNode = adjacent.node;
				int adjWeight = adjacent.weight;
				
				if(weight + adjWeight < dist[adjNode]){
					dist[adjNode] = weight+adjWeight;
					
					pq.add(new Pair(adjNode,dist[adjNode]));
				}
			}
		}
		System.out.println(Arrays.toString(dist));
	}
}


class Pair{
	int node;
	int weight;

	Pair(int node, int weight){
		this.node = node;
		this.weight = weight;
	}
}