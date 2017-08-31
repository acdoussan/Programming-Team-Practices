//Adam Doussan AD844156 07/08/2017

import java.io.*;
import java.util.*;

public class dirichlet
{
	public static long a,b,l,u;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		a = in.nextLong();
		int c = 0;

		while(true)
		{
			c++;

			if(a == 0)
				break;

			b = in.nextLong();
			l = in.nextLong();
			u = in.nextLong();

			long ans = 0;

			if(gcd(a,b) == 1)
				for(long i = l; i <= u; i++)
					if(isPrime(t(i)))
						ans++;

			System.out.format("Case %d: %d\n", c, ans);

			a = in.nextLong();
		}
	}

	public static long gcd(long a, long b)
	{
		return (b == 0) ? a : gcd(b, a%b);
	}

	public static long t(long n)
	{
		return (a*n) + b;
	}

	public static boolean isPrime(long test)
	{
		if(test < 2)
			return false;

		if(test == 2 || test == 3)
			return true;

		if(test % 2 == 0 || test % 3 == 0)
			return false;
	

		long div = 5;
		long w = 2;
		long stop = (long)Math.sqrt(test);

		while(div <= stop)
		{
			if(test % div == 0)
				return false;

			div+= w;
			w = 6 - w;
		}

		return true;
	}
}
