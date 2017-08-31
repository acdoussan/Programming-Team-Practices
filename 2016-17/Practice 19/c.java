// Adam Doussan AD844156 04/01/2017

import java.io.*;
import java.util.*;

public class c
{
	public static int [][] memo;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int n = in.nextInt();
			int l0 = in.nextInt();
			int l1 = in.nextInt();
			int s0 = in.nextInt();
			int s1 = in.nextInt();

			int [][][] diff = new int [2][2][n];

			for(int j = 0; j < 2; j++)
			{
				for(int k = 0; k < 2; k++)
				{
					for(int l = 0; l < n-1; l++)
						diff[j][k][l] = in.nextInt();
				}
			}

			memo = new int [2][n];

			memo[0][n-1] = s0;
			memo[1][n-1] = s1;

			for(int j = n - 2; j >= 0; j--)
			{
				memo[0][j] = Math.min(diff[0][0][j] + memo[1][j+1],
									  diff[0][1][j] + memo[0][j+1]);
				memo[1][j] = Math.min(diff[1][0][j] + memo[0][j+1],
									  diff[1][1][j] + memo[1][j+1]);
			}

			int ans = Math.min(l0 + memo[0][0],
							   l1 + memo[1][0]);

			System.out.println(ans);
		}
	}
/*
	public static int solve(int [][][] diff, int at, int depth, int s0, int s1)
	{
		if(depth = s1d.length - 1)
		{
			return memo [at][depth] = (at == 0) ? s0 : s1;
		}

		return memo[at][depth] = Math.min(diff[at][0][depth] + call(diff, (at + 1) % 2), depth+1, s0, s1),
										  diff[at][1][depth] + call(diff, at, depth+1, s0, s1));
	}
*/
}
