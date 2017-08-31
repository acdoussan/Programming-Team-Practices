// Adam Doussan AD844156 02/18/2017

import java.io.*;
import java.util.*;

public class egypt
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		long n = in.nextLong();
		long m = in.nextLong();

		while(true)
		{
			if(m == 0 && n == 0)
				break;

			ArrayList<Long> ans = new ArrayList<>();

			while(true)
			{
				long nextSub = (long)Math.ceil(((double)m) / n);
				long ansDenom;
				long ansNum;
				boolean split = false;

				while(true)
				{
					ansDenom = lcm(nextSub, m);
					ansNum = ((ansDenom / m) * n) - (ansDenom / nextSub);

					long temp = gcd(ansDenom, ansNum);

					while(temp != 1)
					{
						ansDenom /= temp;
						ansNum /= temp;
						temp = gcd(ansDenom, ansNum);
					}

					if(nextSub > 999999)
					{
						split = true;
						break;
					}

					if(ansDenom > 1000000)
					{
						nextSub++;
						continue;
					}

					break;
				}

				if(split)
				{
					for(int i = 0; i < n; i++)
					{
						ans.add(m);
					}

					break;
				}

				else
				{
					ans.add(nextSub);

					if(ansNum == 1)
					{
						ans.add(ansDenom);
						break;
					}

					n = ansNum;
					m = ansDenom;
				}
			}

			for(int i = 0; i < ans.size(); i++)
			{
				System.out.format("%d%c", ans.get(i), ((i == ans.size() - 1) ? '\n' : ' '));
			}

		 	n = in.nextLong();
			m = in.nextLong();
		}
	}

	public static long lcm(long a, long b)
	{
		return a / gcd(a,b) * b;
	}

	public static long gcd(long a, long b)
	{
		return (b == 0) ? a : gcd(b, a%b);
	}
}
