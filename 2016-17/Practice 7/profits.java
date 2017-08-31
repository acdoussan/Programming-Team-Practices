//Adam Doussan AD844156 10/29/2016

import java.io.*;
import java.util.*;

public class profits
{

	int [] days;
	int length;

	profits()
	{
		Scanner in = new Scanner(System.in);

		length = in.nextInt();

		while(length != 0)
		{
			days = new int [length];

			for(int i = 0; i < length; i++)
				days[i] = in.nextInt();

			int ans = solve();

			System.out.println(ans);

			length = in.nextInt();
		}
	}

	public int solve()
	{
		int currentSum = days[0];
		int maxSum = days[0];

		for(int i = 1; i < length; i++)
		{
			if(currentSum < 0)
				currentSum = 0;

			currentSum += days[i];

			if(currentSum > maxSum)
				maxSum = currentSum;
		}

		return maxSum;
	}

	public static void main(String [] args)
	{
		new profits();
	}
}
