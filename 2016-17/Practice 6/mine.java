//Adam Doussan AD844156 10/22/2016

import java.io.*;
import java.util.*;

public class mine
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int row = in.nextInt(), col = in.nextInt();
		char [][] board;
		int [][] ans;

		while(row != 0 && col != 0)
		{
			board = new char [row][col];
			ans = new int [row][col];

			// Get rid of useless newline left by nextInt
			in.nextLine();

			for(int i = 0; i < row; i++)
			{
				String temp = in.nextLine();

				for(int j = 0; j < col; j++)
					board [i][j] = temp.charAt(j);
			}

			solve(row, col, board, ans);

			
			row = in.nextInt();
			col = in.nextInt();
		}
	}

	public static void solve(int row, int col, char [][] board, int [][] ans)
	{
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(board [i][j] == '*')
				{
					ans[i][j] = -1;
					continue;
				}

				ans[i][j] = sumMines(i,j,board);
			}
		}

		printAns(row, col, ans);
	}

	public static int sumMines(int i, int j, char [][] board)
	{
		int sum = 0;

		try
		{
			if(board[i - 1][j - 1] == '*')
				sum++;
		}
		catch(Exception e){}

		try
		{
			if(board[i - 1][j] == '*')
				sum++;
		}
		catch(Exception e){}

		try
		{
			if(board[i - 1][j + 1] == '*')
				sum++;
		}
		catch(Exception e){}

		try
		{
			if(board[i][j + 1] == '*')
				sum++;
		}
		catch(Exception e){}

		try
		{
			if(board[i + 1][j + 1] == '*')
				sum++;
		}
		catch(Exception e){}

		try
		{
			if(board[i + 1][j] == '*')
				sum++;
		}
		catch(Exception e){}

		try
		{
			if(board[i + 1][j - 1] == '*')
				sum++;
		}
		catch(Exception e){}

		try
		{
			if(board[i][j - 1] == '*')
				sum++;
		}
		catch(Exception e){}

		return sum;
	}

	public static void printAns(int row, int col, int [][] ans)
	{
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				System.out.print((ans[i][j] == -1) ? "*" : ans[i][j]);
			}

			System.out.println();
		}
	}
}
