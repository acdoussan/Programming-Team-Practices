import java.util.*;

public class transport {
	
	public static void main(String [] args)
	{	

		Scanner in = new Scanner(System.in);
		
		int run = in.nextInt();
		
		for(int rr = 0; rr<run; rr++)
		{
			HashMap<String, Integer> atoi = new HashMap<>();
			int c = in.nextInt();
			int [] change = new int [c];
			
			for(int i = 0; i<c; i++)
			{
				String city = in.next();
				int cost = in.nextInt();
				atoi.put(city, atoi.size());
				change[atoi.get(city)]=cost;
			}
			
			atoi.put("AIR", 0);
			atoi.put("RAIL", 1);
			atoi.put("SEA", 2);
			atoi.put("TRUCK", 3);
			
			ArrayList<Edge> [] g = new ArrayList[c];
			
			for(int i = 0; i < c; i++)
				g[i] = new ArrayList<>();
			
			int r = in.nextInt();
			
			for(int i = 0; i<r; i++)
			{
				String to = in.next();
				String from = in.next();
				String type = in.next();
				int cost = in.nextInt();
			
				g[atoi.get(from)].add(new Edge(atoi.get(to), cost, atoi.get(type)));
				g[atoi.get(to)].add(new Edge(atoi.get(from), cost, atoi.get(type)));
			}
			
			int o = atoi.get(in.next()), d = atoi.get(in.next());

			int ans = bfs(g, o, d, change);
			
			System.out.println(ans);
		}
	}
	
	public static int bfs(ArrayList<Edge> [] g, int o, int d, int [] change)
	{
		int n = g.length;
		int [][] dist = new int [n][4];
		
		for(int [] t : dist)
			Arrays.fill(t, (int)1e9);
		
		Arrays.fill(dist[o], 0);
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for(Edge e : g[o])
		{
			pq.add(e);
		}
		
		while(!pq.isEmpty())
		{
			Edge e = pq.remove();
			
			if(dist[e.e][e.m] <= e.w)
				continue;
			
			dist[e.e][e.m] = e.w;
			
			for(Edge to : g[e.e])
			{
				pq.add(new Edge(to.e, e.w+to.w+((e.m == to.m) ? 0 : change[e.e]), to.m));
			}
		}
		
		int ans = dist[d][0];
		
		for(int i = 1; i < 4; i++)
		{
			ans = Math.min(ans, dist[d][i]);
		}
		
		return ans;
	}
}

/*
class Dik
{
	final public static int oo = (int) 1e9;
	private static int n;
	
	public static int[][] run(ArrayList<Edge>[] g, int s, int d, boolean stop, int [] change, String start)
	{
		n = g.length;
		
		boolean [] visited = new boolean[n];
		int [][] dist = new int [n][4];
		Arrays.fill(dist, oo);
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(Edge e : g[s])
		{
			pq.add(new Edge(e.e, e.w, e.mode));
		}
		
		dist[s]=0;
		
		while(!pq.isEmpty())
		{
			Edge at = pq.remove();
			if(visited[at.e]) continue;
			visited[at.e] = true;
			
			if(stop && at.e == d) return dist;


			for(Edge adj : g[at.e])
				if(!visited[adj.e] && adj.w + at.w + ((at.mode.equals(adj.mode)) ? 0 : change[at.e]) < dist[adj.e])
					pq.add(new Edge(adj.e, dist[adj.e] = adj.w + at.w + ((at.mode.equals(adj.mode)) ? 0 : change[at.e]), adj.mode));

		}
		
		return dist;
	}
}
*/

class Edge implements Comparable<Edge>
{
	int e, w, m;
	
	public Edge(int e, int w, int mode)
	{
		this.e=e; this.w=w; this.m=mode;
	}
	
	public int compareTo(Edge o)
	{
		return this.w-o.w;
	}
}
