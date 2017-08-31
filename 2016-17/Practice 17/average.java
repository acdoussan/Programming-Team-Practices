// Adam Doussan AD844156 03/04/2017

import java.io.*;
import java.util.*;

public class average
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int levels = in.nextInt();
			int goal = in.nextInt();

			int [] sums = new int[levels + 1];
			int offset = goal * (levels - 1);
			int runningSum = 0;
			sums[0] = goal*levels;
			for(int j = 1; j < levels + 1; j++)
			{				
				runningSum += in.nextInt();
				sums[j] = runningSum;
				sums[j] += offset;
				offset -= goal;
			}

			//System.out.println(Arrays.toString(sums));

			int [] bit = new int[1000002];
			long ans = 0;
/*
			for(int j = 0; j < levels; j++)
			{
				for(int k = j; k < levels; k++)
				{
					double test;
					if(j == 0)
						test = sums[k];
					else
						test = (double)(sums[k] - sums[j - 1]) / (k - j + 1);

					if(test >= goal)
						ans++;
				}
			}
*/
///*
			add(bit, sums[0]+1);
			for(int j = 1; j <= levels; j++)
			{
				//if(sums[j] >= (goal * levels))
					//ans++;
			   //System.out.println("j = "+j+" adding "+range(bit, sums[j]+1)+" "+(sums[j]+1));
				ans += range(bit, sums[j]+1);
				add(bit, sums[j]+1);
				//System.out.println("added to bit "+(sums[j]+1));
			}
//*/

			System.out.println(ans);
		}
	}

	public static void add(int [] bit, int index)
	{
		while(index < bit.length)
		{
			//System.out.format("Index %d : Value %d\n", index, bit[index] + 1);
			bit[index]++;
			index = index + (index & -index);
		}
	}

	public static long range(int [] bit, int index)
	{
		long ans = 0;

		while(index > 0)
		{
			ans += bit[index];
			index = index - (index & -index);
		}

		return ans;
	}
}
