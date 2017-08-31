//Adam Doussan AD844156 06/03/2017

import java.io.*;
import java.util.*;

public class error
{
	public static ArrayList<ArrayList<Integer>> paths;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int numfl = in.nextInt();
			ArrayList<ArrayList<Edge>> g = new ArrayList<>();
			HashMap<String, Integer> atoi = new HashMap<>();
			HashMap<Integer, String> itoa = new HashMap<>();

			for(int i = 0; i < numfl; i++)
			{
				String left = in.next();
				String right = in.next();

				if(!atoi.containsKey(left))
				{
					atoi.put(left, atoi.size());
					itoa.put(itoa.size(), left);
					g.add(new ArrayList<>());
				}

				if(!atoi.containsKey(right))
				{
					atoi.put(right, atoi.size());
					itoa.put(itoa.size(), right);
					g.add(new ArrayList<>());
				}

				g.get(atoi.get(left)).add(new Edge(atoi.get(right), 1, 0));
				g.get(atoi.get(right)).add(new Edge(atoi.get(left), 1, 0));
			}

			//System.out.println(atoi.size());

			int bought = in.nextInt();
			String [] bfl = new String[bought+1];

			for(int i = 0; i <= bought; i++)
				bfl[i] = in.next();

			HashSet<pair> flights = new HashSet<>();

			for(int i = 0; i < bought; i++)
				flights.add(new pair(bfl[i], bfl[i+1]));

			paths = new ArrayList<>();
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(atoi.get(bfl[bought]));

			int [] dist = Dikstras.run(g.toArray(new ArrayList[0]), atoi.get(bfl[0]));

			//System.out.println(Arrays.toString(dist));

			shortestPaths(g.toArray(new ArrayList[0]), dist, atoi.get(bfl[0]), atoi.get(bfl[bought]), temp);

			int ans = Integer.MAX_VALUE;
			int smallestSize = Integer.MAX_VALUE;

			for(ArrayList<Integer> path : paths)
			{
				//System.out.println(path);
				int myAns = 0;
				HashSet<pair> holder = new HashSet<>();

				for(int i = 0; i < path.size() - 1; i++)
				{
					pair test = new pair(itoa.get(path.get(i)), itoa.get(path.get(i+1)));

					if(flights.contains(test))
					{
						flights.remove(test);
						holder.add(test);
					}
					else
						myAns++;
				}

				if(ans > myAns)
					ans = myAns;

				if(smallestSize > path.size())
				{
					smallestSize = path.size();
					ans = myAns;
				}

				flights.addAll(holder);
			}
/*
			Dikstras.run(g.toArray(new ArrayList[0]), atoi.get(bfl[0]));
			ArrayList<Integer> path = Dikstras.path(atoi.get(bfl[bought]));

			int ans = 0;

			for(int i = 0; i < path.size()-1; i++)
			{
				pair test = new pair(itoa.get(path.get(i)), itoa.get(path.get(i+1)));

				if(flights.contains(test))
					flights.remove(test);
				else
					ans++;
			}
*/
			System.out.println(ans);
		}
	}

	public static void shortestPaths(ArrayList<Edge> g[], int [] dist, int source, int at, ArrayList<Integer> path)
	{
		if(source == at)
		{
			ArrayList<Integer> newP = new ArrayList<>(path);
			Collections.reverse(newP);
			paths.add(newP);
		}

	//	if(at == 1)
		//	System.out.println(g[at].size());

		for(Edge e : g[at])
		{
			//System.out.println("Consider " + e.e);
			if(dist[e.e] < dist[at])
			{
				//System.out.println("going " + e.e);
				path.add(e.e);
				shortestPaths(g, dist, source, e.e, path);
				path.remove(path.size()-1);
			}
		}
	}

	public static void bfs(ArrayList<Edge> g[], int start, int looking)
	{
		boolean [] visited = new boolean [g.length];
		visited[start] = true;

		int [] cameFrom = new int[g.length];

		Queue<Edge> q = new ArrayDeque<>();
		q.add(new Edge(start, 0, start));

		while(!q.isEmpty())
		{
			Edge cur = q.remove();

			for(Edge next : g[cur.e])
			{
				if(!visited[next.e])
				{
					visited[next.e] = true;
					q.add(new Edge(next.e, 0, cur.e));
					cameFrom[next.e] = cur.e;
				}
				if(next.e == looking)
				{
					ArrayList<Integer> path = path(cur.e, start, cameFrom);
					path.add(next.e);
					paths.add(path);
				}
			}
		}
	}

	public static ArrayList<Integer> path(int at, int start, int [] cameFrom)
	{
		if(at == start)
		{
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(at);
			return ans;
		}

		ArrayList<Integer> ans = path(cameFrom[at], start, cameFrom);
		ans.add(at);
		return ans;
	}
}

class pair implements Comparable<pair>
{
	String left, right;

	public pair(String a, String b)
	{
		left = a; right = b;
	}

	public int hashCode()
	{
		return (left+right).hashCode();
	}

	public boolean equals(Object obj)
	{
		if(obj instanceof pair)
			return compareTo((pair)obj) == 0;
		return false;
	}

	public int compareTo(pair o)
	{
		return (left.equals(o.left) && right.equals(o.right)) ? 0 : 1;
	}
}

class Dikstras
{
	final public static int oo = (int)1e9;
	private static int n;
	static int [] cameFrom;
	static int source;

	public static int[] run(ArrayList<Edge>[] g, int s)
	{
		source = s;
		n = g.length;

		boolean [] visited = new boolean [n];
		int [] dist = new int [n];
		cameFrom =  new int [n];

		Arrays.fill(dist, oo);

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(s,0,s));
		dist[s] = 0;

		while(!pq.isEmpty())
		{
			Edge at = pq.remove();
			if(visited[at.e]) continue;
			visited[at.e] = true;
			cameFrom[at.e] = at.c;

			for(Edge adj : g[at.e])
				if(!visited[adj.e] && adj.w + at.w < dist[adj.e])
					pq.add(new Edge(adj.e, dist[adj.e] = adj.w + at.w, at.e));
		}

		return dist;
	}

	public static ArrayList<Integer> path(int goal)
	{
		if(goal == source)
		{
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(goal);
			return ans;
		}

		ArrayList<Integer> ans = path(cameFrom[goal]);
		ans.add(goal);
		return ans;
	}
}

class Edge implements Comparable<Edge>
{
	int e, w, c;

	public Edge(int e, int w, int c)
	{
		this.e = e; this.w = w; this.c = c;
	}

	public int compareTo(Edge o)
	{
		return this.w - o.w;
	}
}
