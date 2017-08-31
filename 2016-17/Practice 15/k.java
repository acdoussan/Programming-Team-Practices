// Adam Doussan AD844156 02/11/2017

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>
{
	public int d, w;
	public HashSet<Integer> notAllowed;
	int cameFrom;

	public Edge(int d, HashSet<Integer> notAllowed)
	{
		this.d = d;
		this.notAllowed = notAllowed;
	}

	public Edge(int d, int w, int cameFrom)
	{
		this.d = d;
		this.w = w;
		this.cameFrom = cameFrom;
	}

	public int compareTo(Edge e)
	{
		return this.w - e.w;
	}
}

public class k
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		HashMap<Integer, ArrayList<Edge>> edges = new HashMap<>();

		int [] times = new int[run];

		for(int i = 0; i < run; i++)
		{
			int numEdges = in.nextInt();
			times[i] = in.nextInt();

			ArrayList<Edge> temp = new ArrayList<>();

			for(int j = 0; j < numEdges; j++)
			{
				int numNotAllowed = in.nextInt();
				int dest = in.nextInt() - 1;

				HashSet<Integer> notAllowed = new HashSet<>();

				for(int k = 0; k < numNotAllowed; k++)
				{
					notAllowed.add(in.nextInt() - 1);
				}

				temp.add(new Edge(dest, notAllowed));
			}

			edges.put(i, temp);
		}

		for(int i = 0; i < run; i++)
		{
			ArrayList<Edge> temp = edges.get(i);

			if(temp != null)
			{
				for(Edge e : temp)
				{
					e.w = times[e.d];
				}
			}
		}

		int ans = dik(edges, 0, run);

		if(ans == -1)
			System.out.println("impossible");
		else
			System.out.println(ans + times[0]);
	}

	public static int dik(HashMap<Integer, ArrayList<Edge>> edges, int start, int numVert)
	{
		int [] dist = new int [numVert];
		Arrays.fill(dist, -1);
		dist[start] = 0;

		PriorityQueue<Edge> q = new PriorityQueue<>();

		if(edges.get(start) != null)
		{
			ArrayList<Edge> temp = edges.get(start);

			for(Edge e : temp)
			{
				q.add(new Edge(e.d, e.w, start));
			}
		}

		while(!q.isEmpty())
		{
			Edge e = q.remove();

			if(dist[e.d] == -1)
			{
				dist[e.d] = e.w;

				if(edges.get(e.d) != null)
				{
					ArrayList<Edge> eList = edges.get(e.d);

					for(Edge temp : eList)
					{
						if(!temp.notAllowed.contains(e.cameFrom))
						{
							q.add(new Edge(temp.d, temp.w + dist[e.d], e.d));
						}
					}
				}
			}
		}

		return dist[numVert - 1];
	}
/*
	public static int dfs(HashMap<Integer, ArrayList<Edge>> edges, int start, int numVert)
	{
		ArrayList<Edge> edge = edges.get(start);

		if(edge == null)
			return (int)1e9;

		int runningMin = (int)1e9;
		boolean [] visited = new boolean [numVert];
		visited[start] = true;

		for(Edge e : edge)
		{
			visited[e.d] = true;
			runningMin = Math.min(runningMin, dfs2(edges, visited, start, e.d, numVert - 1) + e.w);
			visited[e.d] = false;
		}

		return runningMin;
	}

	public static int dfs2(HashMap<Integer, ArrayList<Edge>> edges, boolean [] visited, int source, int current, int goal)
	{
		if(current == goal)
			return 0;

		ArrayList<Edge> edge = edges.get(current);

		if(edge == null)
			return (int)1e9;

		int runningMin = (int)1e9;

		for(Edge e : edge)
		{
			if(!e.notAllowed.contains(source) && !visited[e.d])
			{
				visited[e.d] = true;
				runningMin = Math.min(runningMin, dfs2(edges, visited, current, e.d, goal) + e.w);
				visited[e.d] = false;
			}
		}

		return runningMin;
	}
*/
}
