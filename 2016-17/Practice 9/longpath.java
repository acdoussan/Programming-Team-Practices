//Adam Doussan AD844156 12/03/2016

import java.io.*;
import java.util.*;

public class longpath
{
	int [][] matrix;

	longpath()
	{
		Scanner in = new Scanner(System.in);

		int test = in.nextInt();

		for(int i = 0; i < test; i++)
		{
			int inters = in.nextInt();
			int edges = in.nextInt();

			matrix = new int [inters][inters];

			for(int j = 0; j < inters; j++)
				for(int k = 0; k < inters; k++)
					matrix[j][k] = (int)1e9 + 1;

			for(int j = 0; j < edges; j++)
			{
				int x = in.nextInt();
				int y = in.nextInt();

				matrix[x][y] = in.nextInt();
			}

			System.out.print(dfs() + " ");
			System.out.println(ndfs());
		}
	}

	public int dfs()
	{
		boolean [] visited = new boolean[matrix.length];

		return (int)dfs(0, visited);
	}

	public Integer dfs(int start, boolean [] visited)
	{
		if(start == visited.length - 1)
			return 0;

		if(visited[start])
			return null;

		visited[start] = true;
		Integer length = Integer.MAX_VALUE;

		for(int i = 0; i < visited.length; i++)
		{
			if(matrix[start][i] <= (int)1e9)
			{
				Integer temp = dfs(i, visited);

				if(temp != null)
				{
					length = ((length > temp + matrix[start][i]) ? temp + matrix[start][i] : length);
				}
			}
		}

		visited[start] = false;

		return length;
	}

	public int ndfs()
	{
		boolean [] visited = new boolean[matrix.length];

		return (int)ndfs(0, visited);
	}

	public Integer ndfs(int start, boolean [] visited)
	{
		if(start == visited.length - 1)
			return 0;

		if(visited[start])
			return null;

		visited[start] = true;
		Integer length = 0;

		for(int i = 0; i < visited.length; i++)
		{
			if(matrix[start][i] <= (int)1e9)
			{
				Integer temp = dfs(i, visited);

				if(temp != null)
				{
					length = ((length < temp + matrix[start][i]) ? temp + matrix[start][i] : length);
				}
			}
		}

		visited[start] = false;

		return length;
	}

	public static void main(String [] args)
	{
		new longpath();
	}
}
