//Adam Doussan AD844156 07/08/2017

import java.io.*;
import java.util.*;

public class trees
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int c = 0;
		while(true)
		{
			c++;

			if(n == 0 && m == 0)
				break;

			boolean [][] g = new boolean [n][n];

			for(int i = 0; i < m; i++)
			{
				int a = in.nextInt()-1, b = in.nextInt()-1;
				g[a][b] = true;
				g[b][a] = true;
			}

			boolean [] visited = new boolean [n];

			int ans = countTree(g, visited);

			if(ans == 0)
				System.out.format("Case %d: No trees.\n", c);
			else if(ans == 1)
				System.out.format("Case %d: There is one tree.\n", c);
			else
				System.out.format("Case %d: A forest of %d trees.\n", c, ans);

			n = in.nextInt();
			m = in.nextInt();
		}
	}

	public static int countTree(boolean [][] g, boolean [] visited)
	{
		int ans = 0;
		for(int i = 0; i < visited.length; i++)
		{
			if(!visited[i])
			{
				visited[i] = true;
				ans += (hasCycle(g, visited, i, -1) == true) ? 0 : 1;
			}
		}

		return ans;
	}

	public static boolean hasCycle(boolean [][] g, boolean[] visited, int at, int from)
	{
		boolean cycle = false;
		visited[at] = true;

		for(int i = 0; i < visited.length; i++)
		{
			if(visited[i] && g[at][i] == true && i != from)
				cycle = true;

			if(!visited[i] && g[at][i] == true)
				if(hasCycle(g, visited, i, at) == true)
					cycle = true;
		}

		return cycle;
	}
}
