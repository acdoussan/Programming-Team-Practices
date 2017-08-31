// Adam Doussan AD844156 03/04/2017

import java.io.*;
import java.util.*;

public class electric
{
	public static int poss;
	public static int total;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int points = in.nextInt();
			int charge = in.nextInt();
			int d = in.nextInt();

			int [][] matrix = new int[points + 1][points + 1];

			for(int j = 0; j < points + 1; j++)
			{
				for(int k = 0; k < points + 1; k++)
				{
					matrix[j][k] = in.nextInt();
				}
			}

			poss = 0;
			total = 0;
			boolean [] visited = new boolean [points + 1];
			visited[0] = true;
			dfs(matrix, d, visited, true, 0, 0, charge, d);

			int temp = gcd(poss, total);
			System.out.println((poss / temp) + "/" + (total / temp));
		}
	}

	public static int gcd(int a, int b)
	{
		return (b == 0) ? a : gcd(b, a%b);
	}

	public static void dfs(int [][] m, int d, boolean [] visited, boolean pos, int depth, int start, int charge, int chargeTo)
	{
		if(d < 0)
			pos = false;

		if(start <= charge)
			d = chargeTo;

		if(depth == m.length - 1)
		{
			if(pos == true && (d - m[start][0]) >= 0)
				poss++;
			total++;
			return;
		}

		for(int i = 0; i < m.length; i++)
		{
			if(!visited[i])
			{
				visited[i] = true;
				dfs(m, d - m[start][i], visited, pos, depth + 1, i, charge, chargeTo);
				visited[i] = false;
			}
		}
	}
}
