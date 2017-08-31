//Adam Doussan AD844156 07/08/2017

import java.io.*;
import java.util.*;

public class camper
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		long l = in.nextInt();
		long p = in.nextInt();
		long v = in.nextInt();
		int c = 0;

		while(true)
		{
			c++;

			if(l == 0 && p == 0 && v == 0)
				break;

			System.out.format("Case %d: %d\n", c, ((v/p) * l) + Math.min((v % p), l));

			l = in.nextInt();
			p = in.nextInt();
			v = in.nextInt();
		}
	}
}
