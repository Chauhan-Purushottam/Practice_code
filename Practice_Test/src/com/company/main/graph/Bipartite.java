package com.company.main.graph;

import java.util.*;
import java.lang.*;

class Bipartite
{
	int V,E;
	Bipartite(int v)
	{
		V=v;
	}
	Boolean Bipartite_check(int graph[][],int src,int color[])
	{
		color[src]=1;
		LinkedList<Integer> queue=new LinkedList<Integer>();
		queue.add(src);
		while(queue.size()!=0)
		{
			int u=queue.poll();
			if(graph[u][u]==1)
				return false;
			for(int i=0;i<V;i++)
			{
				if(graph[u][i]==1 && color[i]==-1)
				{
					color[i]=1-color[u];
					queue.add(i);
				}
				else if (graph[u][i]==1 && color[i]==color[u])
                    return false;
			}
		}
		return true;
	}
	Boolean IsBipartite(int graph[][],int v)
	{
		int color[]=new int[v];
		for(int i=0;i<v;i++)
		{
			color[i]=-1;
		}
		for(int i=0;i<v;i++)
		{
			if(color[i]==-1)
			{
				if(Bipartite_check(graph,i,color)==false)
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args)
	{
		int v;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices ");
		v=sc.nextInt();
		int g[][]=new int[v][v];
		System.out.println("Enter the graph:-");
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				g[i][j]=sc.nextInt();
			}
		}
		Bipartite bp=new Bipartite(v);
		if(bp.IsBipartite(g,v))
			System.out.println("Graph is Bipartite ");
		else
			System.out.println("Graph is not Bipartite ");
	} 
}
