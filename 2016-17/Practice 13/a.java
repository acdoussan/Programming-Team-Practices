//Adam Doussan AD844156 01/28/2017

import java.io.*;
import java.util.*;

public class a
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();
		in.nextLine();

		for(int i = 0; i < run; i++)
		{
			String test = in.nextLine();
			Scanner thisTest = new Scanner(test);
			String pref = thisTest.next();
			test = thisTest.next();

			int oct;
			int dec;
			int hex;

			try
			{
				oct = Integer.parseInt(test, 8);
			}
			catch(Exception e)
			{
				oct = 0;
			}

			dec = Integer.parseInt(test);
			hex = Integer.parseInt(test, 16);

			System.out.format("%s %d %d %d\n", pref, oct, dec, hex);
		}
	}
}
