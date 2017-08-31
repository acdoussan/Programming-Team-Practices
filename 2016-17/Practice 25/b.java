//Adam Doussan AD844156 05/27/2017

import java.io.*;
import java.util.*;

public class b
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext())
		{
			long test = in.nextLong();

			boolean [] seen = new boolean [10];

			int count = 0;

			while(!finished(seen))
			{
				count++;
				fill(test*count, seen);
			}

			System.out.println(count);
		}
	}

	public static void fill(long temp, boolean [] seen)
	{
		String num = Long.toString(temp);

		for(int i = 0; i < num.length(); i++)
			seen[num.charAt(i) - '0'] = true;
	}

	public static boolean finished(boolean [] seen)
	{
		for(int i = 0; i < 10; i++)
			if(!seen[i])
				return false;
		return true;
	}
}
