// Adam Doussan AD844156 07/29/2017

import java.io.*;
import java.util.*;


public class g
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		while(in.hasNext())
		{
			int x = in.nextInt();
			int y = in.nextInt();
			int z = in.nextInt();

			int num = x*y;
			int den = z-y;

			long temp = gcd(num,den);

			System.out.println(num/temp + "/" + den/temp);
		}
	}

	public static long gcd(long a, long b)
	{
		return (b == 0) ? a : gcd(b, a%b);
	}
}

