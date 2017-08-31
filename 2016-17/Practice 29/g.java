//Adam Doussan AD844156 07/01/2017

import java.io.*;
import java.util.*;

public class g
{
	public static int seed;
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int a = in.nextInt(), m = in.nextInt();
		seed = in.nextInt();

		//System.out.println(a);
		//System.out.println(m);
		//System.out.println(seed);

		in.nextLine();

		while(in.hasNextLine())
		{
			String test = in.nextLine();
			for(int i = 0; i < test.length(); i++)
			{
				char c = test.charAt(i);
				if((int)c < 0x20 || (int)c > 0x7e)
				{
					System.out.print(test.charAt(i));
				}
				else
				{
					int temp = ((( ((int)c - 32) - ((int)Math.ceil(95 - r(a,m) * 95))) + 95) % 95) + 32;
					//System.out.println(c);
					//System.out.println((int)c);					
					//System.out.println(temp);
					System.out.print((char)temp);
				}
			}
			System.out.println();
		}

	}

	public static double r(int a, int m)
	{
		double val = (seed % m) / ((double)m);
		seed = (a * seed + 1) % m;
		//System.out.println();
		//System.out.println(seed);
		//System.out.println(val);
		return val;
	}
}
