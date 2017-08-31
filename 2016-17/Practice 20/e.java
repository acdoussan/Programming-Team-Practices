// Adam Doussan AD844156 04/08/2017

import java.io.*;
import java.util.*;

public class e
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int num = in.nextInt();

		while(num != 0)
		{
			ArrayList<Integer> test = new ArrayList<>();

			HashSet<Integer> seen = new HashSet<>();

			for(int i = 0; i < num; i++)
			{
				int next = in.nextInt();
				if(seen.contains(next)) continue;
				seen.add(next);
				test.add(next);
			}

			seen = new HashSet<>();

			for(int i = 0; i < test.size(); i++)
			{
				int runningGCD = test.get(i);
				seen.add(runningGCD);
				for(int j = i+1; j < test.size(); j++)
				{
					runningGCD = gcd(runningGCD, test.get(j));
					seen.add(test.get(j));
					seen.add(runningGCD);
				}
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
