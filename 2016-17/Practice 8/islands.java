//Adam Doussan AD844156 11/19/2016

import java.io.*;
import java.util.*;

public class islands
{
	char [][] matrix;
	int row, col;
	boolean [][] visited;

	islands()
	{
		Scanner in = new Scanner(System.in);

		row = in.nextInt();
		col = in.nextInt();

		matrix = new char[row][col];
		visited = new boolean[row][col];

		in.nextLine();

		for(int i = 0; i < row; i++)
		{
			String temp = in.nextLine();

			for(int j = 0; j < col; j++)
				matrix[i][j] = temp.charAt(j);
		}

		System.out.println(solve());
	}

	public int solve()
	{
		int ans = 0;

		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(matrix[i][j] == 'L' && !visited[i][j])
				{
					ans++;
					visited[i][j] = true;
					dfs(i,j);
				}
			}
		}

		return ans;
	}

	public void dfs(int i, int j)
	{
		try
		{
			if(matrix[i+1][j] != 'W' && !visited[i+1][j])
			{
				visited[i+1][j] = true;
				dfs(i+1, j);
			}
		}
		catch(Exception e) {}

		try
		{
			if(matrix[i-1][j] != 'W' && !visited[i-1][j])
			{
				visited[i-1][j] = true;
				dfs(i-1, j);
			}
		}
		catch(Exception e) {}

		try
		{
			if(matrix[i][j+1] != 'W' && !visited[i][j+1])
			{
				visited[i][j+1] = true;
				dfs(i, j+1);
			}
		}
		catch(Exception e) {}

		try
		{
			if(matrix[i][j-1] != 'W' && !visited[i][j-1])
			{
				visited[i][j-1] = true;
				dfs(i, j-1);
			}
		}
		catch(Exception e) {}
	}
	public static void main(String [] args)
	{
		new islands();
	}
}
