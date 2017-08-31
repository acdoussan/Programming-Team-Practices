// Adam Doussan AD844156 04/01/2017

import java.io.*;
import java.util.*;

public class g
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int [][] prof = new int [11][11];

			for(int j = 0; j < 11; j++)
				for(int k = 0; k < 11; k++)
					prof [j][k] = in.nextInt();

			boolean [] visited = new boolean [11];

			System.out.println(solve(prof, 0, visited));
		}
	}

	public static int solve(int [][] prof, int at, boolean [] visited)
	{
		if(at == 11)
			return 0;

		int max = Integer.MIN_VALUE;

		for(int i = 0; i < 11; i++)
		{
			if(!visited[i] && prof[at][i] != 0)
			{
				visited[i] = true;
				max = Math.max(max, prof[at][i] + solve(prof, at+1, visited));
				visited[i] = false;
			}
		}

		return max;
	}
	
}
