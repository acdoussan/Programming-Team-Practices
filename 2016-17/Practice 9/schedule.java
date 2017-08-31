//Adam Doussan AD844156 12/03/2016

import java.io.*;
import java.util.*;

class Point
{
	int index, energy, total;

	Point(int index, int energy)
	{
		this.index = index;
		this.energy = energy;
	}
}

public class schedule
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int r = 0; r < run; r++)
		{
			int c = in.nextInt();
			int t = in.nextInt();
			int l = in.nextInt();

			Point [][] costs = new Point [c][t];

			for(int i = 0; i < c; i++)
			{
				for(int j = 0; j < t; j++)
				{
					
					costs[i][j] = new Point(in.nextInt(), in.nextInt());
				}
			}

			for(int i = 0; i < t; i++)
				costs[c-1][i].total = costs[c-1][i].energy + dist(costs[c-1][i].index, l);

			for(int i = c-2; i >= 0; i--)
			{
				for(int j = 0; j < t; j++)
				{
					costs[i][j].total = costs[i][j].energy + getMin(costs, costs[i][j].index, i + 1);
				}
			}

			int ans = Integer.MAX_VALUE;
			for(int i = 0; i < t; i++)
			{
				if(costs[0][i].total + dist(costs[0][i].index, 0) < ans)
					ans = costs[0][i].total + dist(costs[0][i].index, 0);
			}

			System.out.println(ans);
		}
	}

	public static int getMin(Point [][] costs, int index, int row)
	{
		int runningMin = Integer.MAX_VALUE;

		for(int i = 0; i < costs[0].length; i++)
		{
			int test = costs[row][i].total + dist(index, costs[row][i].index);

			if(test < runningMin)
				runningMin = test;
		}

		return runningMin;
	}

	public static int dist(int index1, int index2)
	{
		if(index1 < index2)
			return dist(index2, index1);

		return index1 - index2;
	}
}
