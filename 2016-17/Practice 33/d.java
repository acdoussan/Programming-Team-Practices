// Adam Doussan AD844156 07/29/2017

import java.io.*;
import java.util.*;

public class d
{
	public static int ans;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		while(in.hasNext())
		{
			int rows = in.nextInt();

			int [][] table = new int [rows][];

			for(int i = 0; i < rows; i++)
			{
				table [i] = new int [in.nextInt()];
			}

			int N = in.nextInt();

			ans = 0;
			tryAll(table, N, 0, 0);

			System.out.println(ans);
		}
	}

	public static void tryAll(int [][] table, int n, int i, int j)
	{
		if(i >= table.length)
		{
			ans++;
			return;
		}

		if(j >= table[i].length)
		{
			tryAll(table, n, i+1, 0);
			return;
		}

		if(i == 0 && j == 0)
		{
			for(int x = 1; x <= n; x++)
			{
				table[i][j] = x;
				tryAll(table, n, i, j+1);
			}
		}

		else if(i == 0)
		{
			for(int x = table[i][j-1]; x <= n; x++)
			{
				table[i][j] = x;
				tryAll(table, n, i, j+1);
			}
		}

		else if(j == 0)
		{
			for(int x = table[i-1][j]+1; x <= n; x++)
			{
				table[i][j] = x;
				tryAll(table, n, i, j+1);
			}
		}

		else
		{
			int start = Math.max(table[i][j-1], table[i-1][j]+1);

			for(int x = start; x <= n; x++)
			{
				table[i][j] = x;
				tryAll(table, n, i, j+1);
			}
		}
	}
}
