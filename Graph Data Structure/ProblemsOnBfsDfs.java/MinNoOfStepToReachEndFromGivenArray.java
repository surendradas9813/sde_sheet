import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{

	public static void main (String[] args) throws java.lang.Exception
	{

		//Our task is to find min no steps required to reach end from start by doing multiplication from the given array at many times you want.
		//for eg start = 2 and end = 100 and arr[] = {2,5,10}
		//O/p: 2 i.e. (2X5X10);
		//if not possible return -1;

		Scanner sc = new Scanner(System.in);

		int start = sc.nextInt();
		int end = sc.nextInt();

		int n = sc.nextInt();
		
		int arr[] = new int[n];

		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();

		System.out.println(solve(start,end,arr,n));
	}


	public static int solve(int start,int end, int arr[], int n){

		//Here we will take start as root node and try to imagine as graph
		//for eg-> start = 2 and end = 100 and arr[]={2,5,10}

		//                     2
		//              2/     5|      10\
		//              /       |         \
		//			4         10         20	
		//        /|\        /|\         /|\
		//      8  20 40  20 50 100(so we return)    
		//  here at third level we will no process for 20 because we have alredy encountered 20 in second level since we reuire minimum no of steps so for this we maintain vis[] array
		//  if we cross beyond end then  we stop further process
		//	here bfs is optimal because we need min no steps and bfs go level wise where as dfs visit root to leaf and then backtrack so more number of operations will be perfomed
		
		boolean isVis[] = new boolean[end+1];

		Queue<Pair> q = new LinkedList<>();
		
		isVis[start] = true;
		q.add(new Pair(start,0));

		while(!q.isEmpty()){

			Pair popped = q.poll();
			int node = popped.node;
			int count = popped.count;

			if(node == end) return count;

			for(int i=0; i<n; i++){

				int newNode = node*arr[i];

				if(newNode <=end && isVis[newNode] == false){
					isVis[newNode] = true;
					q.add(new Pair(newNode,count+1));
				}
			}
		}
		return -1;
	}
}



class Pair{
	int node;
	int count;

	Pair(int node, int count){
		this.node = node;
		this.count = count;
	}
}

