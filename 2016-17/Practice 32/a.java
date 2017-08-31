//Adam Doussan AD844156 07/22/2017

import java.io.*;
import java.util.*;
import java.awt.Point;
public class a
{
	public static long ans;
	final public static int [] dx = {0,1,0,-1};
	final public static int [] dy = {1,0,-1,0};

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int r = in.nextInt(), c = in.nextInt();

			int [][] board = new int [r][c];

			for(int i = 0; i < r; i++)
				for(int j = 0; j < c; j++)
					board[i][j] = in.nextInt();

			ArrayList<Point> starts = new ArrayList<>();

			for(int i = 0; i < r; i++)
				for(int j = 0; j < c; j++)
					if(isStart(i,j,board))
						starts.add(new Point(i,j));
			ans = 0;
			for(Point p : starts)
			{
				boolean [][] visited =  new boolean [r][c];
				visited[p.x][p.y] = true;
				getPaths(p.x, p.y, board, visited);
			}

			System.out.format("Case #%d: %d\n", rr, ans);
		}
	}

	public static boolean isStart(int i, int j, int [][] board)
	{
		int test = board [i][j];
		boolean ret = true;

		for(int k = 0; k < 4; k++)
		{
			if(i+dx[k] < board.length && i+dx[k] >= 0 && j + dy[k] < board[0].length && j+dy[k] >= 0)
			{
				if(test < board [i + dx[k]][j + dy[k]])
				{
					ret = false;
					break;
				}
			}
		}

		return ret;
	}

	public static void getPaths(int i, int j, int [][] board, boolean [][] visited)
	{
		int test = board [i][j];
		boolean isMax = true;
		for(int k = 0; k < 4; k++)
		{
			if(i+dx[k] < board.length && i+dx[k] >= 0 && j + dy[k] < board[0].length && j+dy[k] >= 0 && !visited[i+dx[k]][j+dy[k]])
			{
				if(test > board [i + dx[k]][j + dy[k]])
				{
					visited [i + dx[k]][j + dy[k]] = true;
					getPaths(i + dx[k], j + dy[k], board, visited);
					visited [i + dx[k]][j + dy[k]] = false;
					isMax = false;
				}
			}
		}

		if(isMax)
			ans++;
	}
}
