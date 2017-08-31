// Adam Doussan AD844156 03/25/2017

import java.io.*;
import java.util.*;

class Node
{
	public int x, y;

	Node(int x, int y)
	{
		this.x = x; this.y = y;
	}
}

public class a
{
	public static boolean [][] mat;
	public static boolean [][] visited;
	final static int [] dx = {0,1,0,-1};
	final static int [] dy = {1,0,-1,0};


	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(), m = in.nextInt(), q = in.nextInt();

		mat = new boolean [n][m];

		for(int i = 0; i < q; i++)
		{
			paint(in.nextInt()-1, in.nextInt()-1, in.nextInt()-1, in.nextInt()-1);

			int ans = 0;

			visited = new boolean[n][m];

			for(int j = 0; j < n; j++)
			{
				for(int k = 0; k < m; k++)
				{
					if(!mat[j][k] && !visited[j][k])
					{
						visited[j][k] = true;
						ans++;
						fill(j,k);
					}
				}
			}

			//for(boolean [] temp : mat)
				//System.out.println(Arrays.toString(temp));
			System.out.println(ans);
		}

	}

	public static void paint(int x1, int y1, int x2, int y2)
	{
		if(x1 == x2 && y1 == y2)
			mat[x1][y1] = true;
		else if(x1 == x2)
			for(int i = y1; i <= y2; i++)
				mat[x1][i] = true;
		else if(y1 == y2)
			for(int i = x1; i <= x2; i++)
				mat[i][y1] = true;
	}

	public static void fill(int i, int j)
	{
		Stack<Node> s = new Stack<Node>();

		s.push(new Node(i,j));

		while(!s.isEmpty())
		{
			Node temp = s.pop();

			for(int k = 0; k < 4; k++)
			{
				try
				{
					if(!mat[temp.x + dx[k]][temp.y + dy[k]] && !visited[temp.x + dx[k]][temp.y + dy[k]])
					{
						visited[temp.x + dx[k]][temp.y + dy[k]] = true;
						s.push(new Node(temp.x + dx[k], temp.y + dy[k]));
					}
				}
				catch(Exception e)
				{
				}
			}
		}
	}
}
