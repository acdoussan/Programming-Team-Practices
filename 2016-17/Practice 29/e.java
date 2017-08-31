//Adam Doussan AD844156 07/01/2017

import java.io.*;
import java.util.*;

class pair
{
	public long prime, exp;

	public pair(long p, long e)
	{
		prime = p; exp = e;
	}
}

public class e
{
	public static long [] fib = new long [93];
	

	public static void main(String [] args)
	{
		fillFib();
		Scanner in = new Scanner(System.in);

		while(in.hasNext())
		{
			String temp1 = in.next();
			String temp2 = in.next();

			long lo = Long.parseLong(temp1.substring(2), 16);
			long hi = Long.parseLong(temp2.substring(2), 16);

			if(lo >= hi)
				break;

			boolean seen = false;

			System.out.format("Range %d to %d:\n", lo, hi);
			for(int i = 0; i < 93; i++)
			{
				if(fib[i] > hi)
					break;

				if(fib[i] >= lo)
				{
					seen = true;
					System.out.format("Fib(%d) = %d, lg %s\n", i, fib[i], log(fib[i]));
					ArrayList<pair> fac = primeFactorize(fib[i], i);
					if(fac.size() == 0)
					{
						System.out.println("No prime factors");
					}
					else
					{
						StringBuilder temp = new StringBuilder();

						for(int j = 0; j < fac.size(); j++)
						{
							long prime = fac.get(j).prime;
							long exp = fac.get(j).exp;

							for(long k = 0; k < exp; k++)
							{
								temp.append(prime + " ");
							}
						}

						String ans = temp.toString();
						ans.trim();

						System.out.format("Prime factors: %s\n", ans);
					}
				}
			}

			if(!seen)
				System.out.println("No Fibonacci numbers in the range");

			System.out.println();
		}
	}

	public static void fillFib()
	{
		fib[0] = 0;
		fib[1] = 1;

		for(int i = 2; i < 93; i++)
			fib[i] = fib[i-1] + fib[i-2];
	}

	public static String log(long fib)
	{
		if(fib == 0)
			return "does not exist";


		double log = Math.log(fib) / Math.log(2);

		return String.format("is %.6f", log);
	}

	public static ArrayList<pair> primeFactorize(long n, int idx)
	{
		ArrayList<pair> res = new ArrayList<>();
		long div = 2;

		while(div*div <= n)
		{
			long exp = 0;
			while(n % div == 0)
			{
				n /= div;
				exp++;
			}

			if(exp > 0) res.add(new pair(div, exp));
			div++;
		}

		if(n > 1) res.add(new pair(n,1));
		return res;
	}
}
