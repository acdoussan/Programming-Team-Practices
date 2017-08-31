// Adam Doussan AD844156 02/11/2017

import java.io.*;
import java.util.*;

public class j
{
	public static int [][] memo;
	public static int [][] pay;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int cpu = in.nextInt();
		int merch = in.nextInt();

		pay = new int [merch][cpu + 1];
		memo = new int [merch][cpu + 1];

		for(int [] a : memo)
			Arrays.fill(a, -1);

		for(int i = 0; i < merch; i++)
		{
			for(int j = 1; j <= cpu; j++)
			{
				pay[i][j] = in.nextInt();
			}
		}

		System.out.println(eval(0, cpu, merch));
	}

	public static int eval(int merchant, int cpuCount, int stop)
	{
		if(merchant == stop || cpuCount == 0)
			return 0;

		if(memo[merchant][cpuCount - 1] != -1)
			return memo[merchant][cpuCount];

		int max = 0;

		for(int i = 0; i <= cpuCount; i++)
		{
			max = Math.max(max, pay[merchant][i] + eval(merchant + 1, cpuCount - i, stop));
		}

		memo[merchant][cpuCount] = max;

		return max;
	}
}
