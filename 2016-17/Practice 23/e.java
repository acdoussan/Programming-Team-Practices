//Adam Doussan AD844156 05/13/2017

import java.io.*;
import java.util.*;

class call
{
	int x, y, stage, depth;

	public call(int x, int y, int stage, int depth)
	{
		this.x = x; this.y = y; this.stage = stage; this.depth = depth;
	}
}

public class e
{
	public static int [] dx = {0,1,0,-1};
	public static int [] dy = {1,0,-1,0};

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int h = in.nextInt(), w = in.nextInt();
		in.nextLine();

		char [][] board = new char[h][w];

		for(int i = 0; i < h; i++)
		{
			String temp = in.nextLine();
			for(int j = 0; j < w; j++)
			{
				board[i][j] = temp.charAt(j);
			}
		}

		Stack<call> s1 = new Stack<>();
		Stack<call> s2 = new Stack<>();
		boolean [][] visited = new boolean[h][w];
		visited [0][0] = true;
		s1.add(new call(0,0,1,1));
		int ans = 1;

		while(!s1.isEmpty() || !s2.isEmpty())
		{
			call next;

			if(!s1.isEmpty())
				next = s1.pop();
			else
				next = s2.pop();

			ans = Math.max(ans, next.depth);

			if(next.stage == 1)
			{
				char looking = board[next.x][next.y];
				int x = next.x, y = next.y;
				s2.add(new call(x, y, 2, next.depth));

				for(int i = 0; i < 4; i++)
				{
					try
					{
						if(!visited[x+dx[i]][y+dy[i]] && board[x+dx[i]][y+dy[i]] == looking)
						{
							visited[x+dx[i]][y+dy[i]] = true;
							s1.add(new call(x+dx[i], y+dy[i], 1, next.depth));
						}
					}
					catch(Exception e)
					{
					}
				}
			}

			else
			{
				char looking = (board[next.x][next.y] == 'R') ? 'F' : 'R';
				int x = next.x, y = next.y;

				for(int i = 0; i < 4; i++)
				{
					try
					{
						if(!visited[x+dx[i]][y+dy[i]] && board[x+dx[i]][y+dy[i]] == looking)
						{
							visited[x+dx[i]][y+dy[i]] = true;
							s1.add(new call(x+dx[i], y+dy[i], 1, next.depth+1));
						}
					}
					catch(Exception e)
					{
					}
				}
			}
		}

		//int ans = dfs(0, 0, looking, board, visited, 1);

		System.out.println(ans);
	}

	public static int dfs(int x, int y, char looking, char[][] board, boolean [][] visited, int depth)
	{
		int ans = depth;

		for(int i = 0; i < 4; i++)
		{
			try
			{
				if(!visited[x+dx[i]][y+dy[i]] && board[x+dx[i]][y+dy[i]] == looking)
				{
					visited[x+dx[i]][y+dy[i]] = true;
					ans = Math.max(dfs(x+dx[i], y+dy[i], looking, board, visited, depth), ans);
				}
			}
			catch(Exception e)
			{
			}
		}

		looking = (looking == 'R') ? 'F' : 'R';

		for(int i = 0; i < 4; i++)
		{
			try
			{
				if(!visited[x+dx[i]][y+dy[i]] && board[x+dx[i]][y+dy[i]] == looking)
				{
					visited[x+dx[i]][y+dy[i]] = true;
					ans = Math.max(dfs(x+dx[i], y+dy[i], looking, board, visited, depth+1), ans);
				}
			}
			catch(Exception e)
			{
			}
		}

		return ans;
	}
}
