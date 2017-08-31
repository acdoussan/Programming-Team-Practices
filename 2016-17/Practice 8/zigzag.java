//Adam Doussan AD844156 11/19/2016

import java.io.*;
import java.util.*;

public class zigzag
{
	int [] seq;
	int run;

	zigzag()
	{
		Scanner in = new Scanner(System.in);

		run = in.nextInt();
		seq = new int[run];

		for(int i = 0; i < run; i++)
		{
			seq[i] = in.nextInt();
		}

		int ans = Math.max(solve_memo(true), solve_memo(false));

		System.out.println(ans);
	}

	public int solve_memo(boolean start)
	{
		int runningMax = -1;

		for(int k = 0; k < run - 1; k++)
		{

			boolean [] lastAct = new boolean[run];
			Arrays.fill(lastAct, start);

			int [] memo = new int[run];
			Arrays.fill(memo, 1);

			int [] lastIndex = new int [run];

			for(int i = 0; i < run; i++)
			{
				lastIndex[i] = i;
			}

			for(int i = k; i < run; i++)
			{
				for(int j = 1; j < run; j++)
				{
					if(lastIndex[j] >= j)
						continue;

					if(lastAct[j])
					{
						if(seq[lastIndex[j]] > seq[i])
						{
							lastIndex[j] = i;
							memo[j]++;
							lastAct[j] = !lastAct[j];
						}
					}
					if(!lastAct[j])
					{
						if(seq[lastIndex[j]] < seq[i])
						{
							lastIndex[j] = i;
							memo[j]++;
							lastAct[j] = !lastAct[j];
						}
					}
				}
			}

			for(int i = 0; i < run; i++)
				runningMax = ((runningMax < memo[i]) ? memo[i] : runningMax);
		}

		return runningMax;
	}

	public int solve(int index, boolean dir)
	{
		if(index < 0)
			return 1;

		// don't use it
		int temp = solve(index - 1, dir);

		if(dir)
		{
			if(seq[index] > seq[index+1])
				return Math.max(temp, 1 + solve(index - 1, !dir));
		}

		if(!dir)
		{
			if(seq[index] < seq[index+1])
				return Math.max(temp, 1 + solve(index - 1, !dir));
		}

		return temp;
	}

	public static void main(String [] args)
	{
		new zigzag();
	}
}
