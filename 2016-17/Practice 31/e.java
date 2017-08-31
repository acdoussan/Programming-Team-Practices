//Adam Doussan AD844156 07/15/2017

import java.io.*;
import java.util.*;

class Point implements Comparable<Point>
{
	int x,y;
	int dist;

	public Point(int x, int y, int dist)
	{
		this.x = x; this.y = y; this.dist = dist;
	}

	public boolean equals(Point o)
	{
		return x == o.x && y == o.y;
	}

	public int compareTo(Point o)
	{
		return this.dist - o.dist;
	}
}

public class e
{
	final public static int [] dx = {0, 1, 0 , -1};
	final public static int [] dy = {1, 0, -1 , 0};

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int m = in.nextInt();
			int n = in.nextInt();
			in.nextLine();

			char [][] board = new char[m][n];
			int [][] dist = new int [m][n];

			for(int [] a : dist)
				Arrays.fill(a, Integer.MAX_VALUE);

			ArrayList<Point>tele = new ArrayList<>();
			Point s = null;
			Point d = null;

			for(int i = 0; i < m; i++)
			{
				String line = in.nextLine();
				for(int j = 0; j < n; j++)
				{
					board[i][j] = line.charAt(j);

					if(board[i][j] == '*')
						tele.add(new Point(i,j,0));
					if(board[i][j] == 'P')
						s = new Point(i,j,0);
					if(board[i][j] == 'D')
						d = new Point(i,j,0);
				}
			}


			if(tele.size() == 1)
			{
				board[tele.get(0).x][tele.get(0).y] = '#';
				tele = new ArrayList<>();
			}


			travel(board, dist, s, tele);

			if(dist[d.x][d.y] == Integer.MAX_VALUE)
				System.out.format("Case %d: impossible\n", rr);
			else
				System.out.format("Case %d: %d\n", rr, dist[d.x][d.y]);
		}
	}

	public static void travel(char [][] board, int [][] dist, Point start, ArrayList<Point> tele)
	{
		PriorityQueue<Point> q = new PriorityQueue<>();

		q.add(start);
		dist[start.x][start.y] = 0;

		boolean stars = false;
		Point temp;
		while(!q.isEmpty())
		{
			Point p = q.remove();

			for(int i = 0; i < 4; i++)
			{
				if(board[p.x+dx[i]][p.y+dy[i]] == '.' && dist[p.x+dx[i]][p.y+dy[i]] > dist[p.x][p.y]+1)
				{
					q.add(new Point(p.x+dx[i], p.y+dy[i], dist[p.x][p.y] + 1));
					dist[p.x+dx[i]][p.y+dy[i]] = dist[p.x][p.y] + 1;
				}

				else if(!stars && board[p.x+dx[i]][p.y+dy[i]] == '*' && dist[p.x+dx[i]][p.y+dy[i]] > dist[p.x][p.y]+1)
				{
					boolean jumpBack = false;
					int cost = 5;
					Point star = new Point(p.x+dx[i], p.y+dy[i], dist[p.x][p.y] + 4);

					for(Point t : tele)
					{
						if(!t.equals(star) && dist[t.x][t.y] > dist[p.x][p.y] + 2)
						{
							q.add(new Point(t.x, t.y, dist[p.x][p.y]+2));
							dist[t.x][t.y] = dist[p.x][p.y] + 2;
						}

						for(int j = 0; j < 4; j++)
						{
							if(board[t.x+dx[j]][t.y+dy[j]] == '*')
							{
								jumpBack = true;
								cost = 4;
							}

							else if(board[t.x+dx[j]][t.y+dy[j]] == '.')
							{
								jumpBack = true;
							}
						}
					}

					if(jumpBack)
					{
						q.add(star);
						dist[p.x+dx[i]][p.y+dy[i]] = dist[p.x][p.y] + cost;
					}
					stars = true;
				}

				else if(board[p.x+dx[i]][p.y+dy[i]] == 'D')
				{
					dist[p.x+dx[i]][p.y+dy[i]] = dist[p.x][p.y] + 1;
				}
			}
		}
	}
}
