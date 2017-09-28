// Adam Doussan AD844156 09/23/2017

import java.io.*;
import java.util.*;

public class bunnies
{

	public static int [] dx = {1,0,-1,0};
	public static int [] dy = {0,1,0,-1};

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int r = in.nextInt();
			int c = in.nextInt();
			in.nextLine();

			char [][] board = new char [r][c];
			boolean [][] visited = new boolean [r][c];

			int sx = 0;
			int sy = 0;

			for(int i = 0; i < r; i++)
			{
				String line = in.nextLine();

				for(int j = 0; j < c; j++)
				{
					board [i][j] = line.charAt(j);

					if(line.charAt(j) == 'P')
					{
						sx = i;
						sy = j;
					}
				}
			}

			visited[sx][sy] = true;

			if(dfs(sx,sy,board,visited))
				System.out.println("yes");
			else
				System.out.println("no");
			
		}
	}

	public static boolean dfs(int x, int y, char [][] board, boolean [][] visited)
	{
		if(board[x][y] == '#')
			return false;
		if(board[x][y] == 'C')
			return true;

		for(int i = 0; i < 4; i++)
		{
			try
			{
				if(!visited[x+dx[i]][y+dy[i]])
				{
					visited[x+dx[i]][y+dy[i]] = true;
					if(dfs(x+dx[i], y+dy[i], board, visited) == true)
						return true;
				}
			}
			catch(Exception e)
			{
			}
		}

		return false;
	}
}
