//Adam Doussan AD844156 10/01/2016

import java.io.*;
import java.util.*;

public class help
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int numQ = in.nextInt();
			int dollaDolla = in.nextInt();

			System.out.println(numQ);
			System.out.println(dollaDolla);

			int [] min = new int [numQ];
			int [] val = new int [numQ];
			
			for(int j = 0; j < numQ; j++)
			{
				min[j] = in.nextInt();
				val[j] = in.nextInt();
			}

			int ans = getMaxComb(min, val, 1, dollaDolla);
	
			System.out.format("Day #%d: %d%n",i + 1,ans);
		}
	}

	public static int getMaxComb(int [] min, int [] val, int length, int dollaDolla)
	{
		int [] indexes = new int[length];
		int max = 0;

		for(int i = 0; i < indexes.length; i++)
			indexes[i] = i;

		while(indexes[indexes.length - 1] < min.length)
		{
			
			for(int i = 0; i < indexes.length; i++)
				System.out.print(indexes[i] + " ");
			System.out.println();

			int test = 0;
			int value = 0;

			for(int i = 0; i < indexes.length; i++)
				test += min[i];

			if(test <= dollaDolla)
				for(int i = 0; i < indexes.length; i++)
					value += val[i];

			if(value > max)
				max = value;

			indexes[indexes.length - 1] += 1;
			System.out.println(indexes[indexes.length - 1]);

			boolean reset = false;

			if(indexes.length > 1)
				for(int i = indexes.length - 1; i > 0; i--)
					if((indexes[i] - ((indexes.length - 1) - i) ) % min.length == 0)
					{
						indexes[i - 1]++;
						indexes[i] = 0;
						System.out.println(indexes[i - 1] + " " + indexes[i] + "THE FUCK" );
						reset = true;
					}
			if(reset)
				for(int i = 1; i < indexes.length; i++)
					indexes[i] = indexes[i - 1] + 1;
		}

		if(length < min.length)
		{
			int temp = getMaxComb(min, val, length + 1, dollaDolla);
			if(temp > max)
				return temp;
			return max;
		}
		else
			return max;
	}
}
