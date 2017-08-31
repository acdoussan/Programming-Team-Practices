//Adam Doussan AD844156 10/29/2016

import java.io.*;
import java.util.*;

public class maximumsquare
{
	boolean [][] board;
	int [][] memo;
	int row, col;

	maximumsquare()
	{
		Scanner in = new Scanner(System.in);

		row = in.nextInt();
		col = in.nextInt();

		while(row != 0 && col != 0)
		{
			board = new boolean [row][col];
			memo = new int [row][col];

			for(int i = 0; i < row; i++)
				for(int j = 0; j < col; j++)
					board [i][j] = (in.nextInt() == 1) ? true : false;

			solve();

			row = in.nextInt();
			col = in.nextInt();
		}

		in.close();
	}

	public void solve()
	{
		int ans = 0;

		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(board[i][j])
				{
					int temp = expand(i, j);
					if(temp > ans)
						ans = temp;
				}
				else
				{
					memo[i][j] = 0;
				}
			}
		}
		
		System.out.println(ans);	
	}

	public int expand(int i, int j)
	{
		int temp = 0;

		try
		{
			temp = memo[i-1][j-1];
		}
		catch(Exception e)
		{
			memo[i][j] = 1;
			return 1;
		}

		try
		{
			temp = ((memo[i][j-1] < temp) ? memo[i][j-1] : temp);
		}
		catch(Exception e)
		{
			memo[i][j] = 1;
			return 1;
		}

		try
		{
			temp = ((memo[i-1][j] < temp) ? memo[i-1][j] : temp);
		}
		catch(Exception e)
		{
			memo[i][j] = 1;
			return 1;
		}

		memo[i][j] = temp + 1;
		return temp + 1;
	}

	public static void main(String [] args)
	{
		new maximumsquare();
	}
}
