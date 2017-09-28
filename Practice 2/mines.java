// Adam Doussan AD844156 09/23/2017

import java.io.*;
import java.util.*;

public class mines
{
	public static int [] dx = {1,0,-1,0,0,0};
	public static int [] dy = {0,1,0,-1,0,0};
	public static int [] dz = {0,0,0,0,1,-1};

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int [][][] mine = new int [n][n][n];

		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				for(int k = 0; k < n; k++)
					mine[i][j][k] = in.nextInt();

		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
			boolean [][][] visited = new boolean [n][n][n];
			visited [x][y][z] = true;
			System.out.format("Simulation #%d, volume cleared is %d cubic feet.\n\n", rr, dfs(x,y,z,mine,visited));
		}
	}

	public static int dfs(int x, int y, int z, int [][][] mine, boolean [][][] visited)
	{
		if(mine[x][y][z] == 0)
			return 0;

		int temp = 1;

		for(int i = 0; i < 6; i++)
		{
			try
			{
				if(!visited[x+dx[i]][y+dy[i]][z+dz[i]])
				{
					visited[x+dx[i]][y+dy[i]][z+dz[i]] = true;
					temp += dfs(x+dx[i],y+dy[i],z+dz[i], mine, visited);
				}
			}
			catch(Exception e)
			{
			}
		}

		return temp;
	}
}
