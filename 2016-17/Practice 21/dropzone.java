// Adam Doussan AD844156 04/22/2017

import java.io.*;
import java.util.*;

public class dropzone
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int r = in.nextInt(), c = in.nextInt();
			in.nextLine();
			char[][] board = new char[r][c];

			for(int j = 0; j < r; j++)
			{
				String next = in.nextLine();

				for(int k = 0; k < c; k++)
					board[j][k] = next.charAt(k);
			}
		}
	}
}

class Dinic
{
	ArrayDeque<Integer> q;
	ArrayList<Edge>[] adj;
	int n, s, t, oo = (int)1E9;
	boolean[] blocked;
	int[] dist;

	public Dinic (int N)
	{
		n = N; s = n++; t = n++;
		blocked = new boolean[n];
		dist = new int[n];
		q = new ArrayDeque<Integer>();
		adj = new ArrayList[n];
		for(int i = 0; i < n; ++i)
			adj[i] = new ArrayList<Edge>();
	}

	void add(int v1, int v2, int cap, int flow)
	{
		Edge e = new Edge(v1, v2, cap, flow);
		Edge rev = new Edge(v2, v1, 0, 0);
		adj[v1].add(rev.rev = e);
		adj[v2].add(e.rev = rev);
	}

	boolean bfs()
	{
		q.clear();
		Arrays.fill(dist, -1);
		dist[t] = 0;
		q.add(t);
			
		while(!q.isEmpty()) {
			int node = q.poll();
			if(node == s) 
				return true;
			for(Edge e : adj[node])
			{
				if(e.rev.cap > e.rev.flow && dist[e.v2] == -1)
				{
					dist[e.v2] = dist[node] + 1;
					q.add(e.v2);
				}
			}
		}
		return dist[s] != -1;
	}
		
	int dfs(int pos, int min)
	{
		if(pos == t) 
			return min;
		int flow = 0;
		for(Edge e : adj[pos])
		{
			int cur = 0;
			if(!blocked[e.v2] && dist[e.v2] == dist[pos]-1 && e.cap - e.flow > 0)
			{
				cur = dfs(e.v2, Math.min(min-flow, e.cap - e.flow));
				e.flow += cur;
				e.rev.flow = -e.flow;
				flow += cur;
			}
			if(flow == min)
				return flow;
		}
		blocked[pos] = flow != min;
		return flow;
	}
	
	int flow()
	{
		clear();
		int ret = 0;
		while(bfs())
		{
			Arrays.fill(blocked, false);
			ret += dfs(s, oo);
		}
		return ret;
	}
	
	void clear()
	{
		for(ArrayList<Edge> edges : adj)
			for(Edge e : edges)
				e.flow = 0;
	}
}

class Edge
{
	int v1, v2, cap, flow;
	Edge rev;
	Edge(int V1, int V2, int Cap, int Flow)
	{
		v1 = V1; v2 = V2; cap = Cap; flow = Flow;
	}
}
