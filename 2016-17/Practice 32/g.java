//Adam Doussan AD844156 07/22/2017

import java.io.*;
import java.util.*;

public class g
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();
		long [] pre = new long [100000];

		for(int i = 1; i < 100000; i++)
			pre[i] = pre[i-1] + i;

		for(int rr = 1; rr <= run; rr++)
		{
			int n = in.nextInt(), m = in.nextInt();

			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

			for(int i = 0; i < n; i++)
				adj.add(new ArrayList<>());

			for(int i = 0; i < m; i++)
			{
				int x = in.nextInt()-1, y = in.nextInt()-1;

				adj.get(x).add(y);
				adj.get(y).add(x);
			}

			HashSet<Integer> bad = new HashSet<>();
			HashSet<Integer> visited = new HashSet<>();

			for(int i = 0; i < n; i++)
			{
				if(!visited.contains(i) && !bad.contains(i))
				{
					findCycle(i, -1, adj, bad, visited, new ArrayList<>());
				}
			}

			visited = new HashSet<>();
			long ans = 0;

			for(int i = 0; i < n; i++)
			{
				if(!visited.contains(i) && !bad.contains(i))
				{
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(i);
					visited.add(i);
					getComp(i, adj, bad, visited, temp);
					ans += pre[temp.size()-1];
				}
			}

			System.out.format("Case #%d: %d\n", rr, ans);
		}
	}

	public static void findCycle(int at, int from, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> bad, HashSet<Integer> seen, ArrayList<Integer> path)
	{
		for(int node : adj.get(at))
		{
			if(node != from && seen.contains(node) && !bad.contains(at))
			{
				int i = path.size() - 1;
				while(i >= 0 && path.get(i) != node)
				{
					bad.add(path.get(i--));
				}
				bad.add(node);
			}

			else if(node != from && !seen.contains(node))
			{
				seen.add(node);
				path.add(node);
				findCycle(node, at, adj, bad, seen, path);
				path.remove(path.size()-1);
			}
		}
	}

	public static void getComp(int at, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> bad, HashSet<Integer> seen, ArrayList<Integer> ans)
	{
		for(int node : adj.get(at))
		{
			if(!seen.contains(node) && !bad.contains(node))
			{
				ans.add(node);
				seen.add(node);
				getComp(node, adj, bad, seen, ans);
			}
		}
	}
}
