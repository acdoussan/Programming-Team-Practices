// Adam Doussan AD844156 04/22/2017

import java.io.*;
import java.util.*;

public class bones
{
	final public static int oo = -1;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int r = 0; r < run; r++)
		{
			int n = in.nextInt(), k = in.nextInt(), m = in.nextInt();

			int [][] mat = new int [n][n];

			for(int [] temp : mat)
				Arrays.fill(temp, oo);
			for(int j = 0; j < n; j++)
				mat[j][j] = 0;

			for(int j = 0; j < m; j++)
			{
				int v1 = in.nextInt();
				int v2 = in.nextInt();
				int w = in.nextInt();

				mat[v1][v2] = w;
				mat[v2][v1] = w;
			}

			long [][] shortest = Floyd.run(mat);
			int [][] path = Floyd.path;
			for(int [] temp : path)
				System.out.println(Arrays.toString(temp));
			System.out.println();
			for(long [] temp : shortest)
				System.out.println(Arrays.toString(temp));
			for(int [] temp : mat)
				System.out.println(Arrays.toString(temp));
			long [] ans = new long [n];
			Arrays.fill(ans, Long.MAX_VALUE);

			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					if(i != j)
					//if(ans[j] < shortest[i][j])
					//{
					//	System.out.println(i + " " + j);
						ans[j] = Math.min(ans[j], calculate(mat, path, i, j, k));
				//	}

			long finalAns = ans[0];

			System.out.println(Arrays.toString(ans));

			for(int i = 1; i < ans.length; i++)
				finalAns = Math.max(finalAns, ans[i]);

			System.out.println(finalAns);
		}
	}

	public static long calculate(int [][] mat, int [][] path, int i, int j, int k)
	{
		int tempi = i;
		int tempj = j;
		if(path[i][j] == -1)
			return Long.MAX_VALUE;

		ArrayList<Integer> myPath = new ArrayList<>();

		myPath.add(i);

		while(i != j)
		{
			i = path[i][j];
			myPath.add(i);
		}

		//System.out.println(i + " " + j);
		if(tempi ==1  && tempj == 3)
			System.out.println(myPath);

		long low = 0;
		long high = Long.MAX_VALUE;
		long mid;

		while(low < high-1)
		{
			mid = ((high - low) / 2) + low;


			int temp = test(mid, myPath, mat);

			if(tempi ==1  && tempj == 3)
				System.out.println("low: " + low + " mid: " + mid + " high: " + high + " test " + temp);

			if(test(mid, myPath, mat) < k)
				high = mid;
			else
				low = mid;
		}

		if(test(low, myPath, mat) < k)
			return low;
		else
			return high;
	}

	public static int test(long charge, ArrayList<Integer> myPath, int [][] mat)
	{
		long current = charge;
		int ans = 0;

		for(int i = 0; i < myPath.size() - 1; i++)
		{
			if(mat[myPath.get(i)][myPath.get(i+1)] > charge)
				return Integer.MAX_VALUE;
			if(mat[myPath.get(i)][myPath.get(i+1)] > current)
			{
				current = charge;
				ans++;
			}

			current -= mat[myPath.get(i)][myPath.get(i+1)];
		}

		return ans;
	}
}

class Floyd
{
	public static int [][] path;

	public static long [][] run(int [][] adj)
	{
		path = new int[adj.length][adj.length];

		for(int i = 0; i < adj.length; i++)
			for(int j = 0; j < adj.length; j++)
				if(adj[i][j] != -1)
					path[i][j] = j;
				else
					path[i][j] = -1;

		int n = adj.length;
		long [][] m = copy(adj);

		for(int k = 0; k < n; k++)
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					if(m[i][k] != -1 && m[k][j] != -1)
						if(m[i][k] + m[k][j] < m[i][j] || m[i][j] == -1)
						{
							m[i][j] = m[i][k] + m[k][j];
							path[i][j] = path[i][k];
						}

		return m;
	}

	public static long [][] copy(int [][] a)
	{
		long [][] res = new long [a.length][a[0].length];
			for(int i = 0; i < a.length; i++)
				for(int j = 0; j < a[0].length; j++)
					res[i][j] = a[i][j];
		return res;
	}
}
