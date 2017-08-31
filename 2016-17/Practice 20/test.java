// Adam Doussan AD844156 04/08/2017

import java.io.*;
import java.util.*;

public class test
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int num = in.nextInt();

		while(num != 0)
		{
			int [] seq = new int[num];

			for(int i = 0; i < num; i++)
				seq[i] = in.nextInt();

			Arrays.sort(seq);

			HashSet<Integer> seen = new HashSet<>();

			int runningGCD = seq[num-1];
			seen.add(runningGCD);

			for(int i = num-2; i >= 0; i--)
			{
				int temp = gcd(runningGCD, seq[i]);
				seen.add(seq[i]);

				if(temp == 1)
				{
					seen.add(temp);
					continue;
				}

				runningGCD = temp;
				seen.add(runningGCD);
			}

			System.out.println(seen.size());

			num = in.nextInt();
		}
	}

	public static int gcd(int a, int b)
	{
		return (b == 0) ? a : gcd(b, a%b);
	}
}
