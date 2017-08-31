//Adam Doussan AD844156 05/27/2017

import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class g
{
	public static long [][] choose = chooseDP(55);

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		while(in.hasNext())
		{
			long test = in.nextLong();
			int bitCount = Long.bitCount(test);
			String myTest = new StringBuilder(Long.toString(test, 2)).reverse().toString();
			//System.out.println(myTest);

			long ans = (bitCount % 3 == 0) ? 1 : 0;

			for(int bit = 0; bit < myTest.length(); bit++)
			{
				if(myTest.charAt(bit) != '1')
					continue;

				bitCount--;

				for(int i = 0; i <= bit; i++)
					if((i+bitCount) % 3 == 0 && i+bitCount != 0)
						ans += choose[bit][i];
			}

			System.out.format("Day %d: Level = %s\n", test, ans);
		}
	}

	public static long [][] chooseDP(int maxDepth)
	{
		long[][] choose = new long[maxDepth][maxDepth];

		for (int i = 0; i < maxDepth; i++)
		{
			choose[i][0] = choose[i][i] = 1;

			for (int j = 1; j < i; j++) 
				choose[i][j] = choose[i-1][j] + choose[i-1][j-1];
		}

		return choose;
	}
}
