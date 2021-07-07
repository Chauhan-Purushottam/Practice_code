package com.company.main.graph;
import java.util.*;
@SuppressWarnings("unchecked")
class Graph
	{
		private int V;
		LinkedList <Integer> array[];
		Graph(int v)
		{
			this.V=v;
			array=new LinkedList[V];
			for(int i=0;i<V;i++)
			{
				array[i]=new LinkedList<>();
			}
		}
	void addEdge(int s,int d)
	{
		array[s].add(d);
	}
	void dfsutil(int n,boolean visit[])
	{
		visit[n]=true;
		System.out.print(n+" ");
		Iterator<Integer> i=array[n].listIterator();
		while(i.hasNext())
		{
			int p=i.next();
			if(!visit[p])
			{
				dfsutil(p,visit);
			}
		}
	}
	void dfs(int v)
	{
		boolean visit[]=new boolean[V];
		dfsutil(v,visit);
	}
	public static void main(String[] args)
	{
		int n=7;
		//Scanner sc=new Scanner(System.in);
		//System.out.println("Enter the number of Node ");
		//n=sc.nextInt();
		Graph d=new Graph(n);
		d.addEdge(0,1);
		d.addEdge(0,2);
		d.addEdge(2,3);
		d.addEdge(2,4);
		d.addEdge(4,6);
		d.addEdge(2,5);
		System.out.println("The DFS Traversal of the graph "+"starting from vertex 2 is \n");
		d.dfs(0);
		System.out.print("\n");
	}


}