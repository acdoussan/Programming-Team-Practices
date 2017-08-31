//Adam Doussan AD844156 05/27/2017

import java.io.*;
import java.util.*;

public class a
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		int [] good = {1,2,3,3,4,10};
		int [] bad = {1,2,2,2,3,5,10};

		for(int rr = 1; rr <= run; rr++)
		{
			long left = 0;
			long right = 0;

			for(int i = 0; i < good.length; i++)
				left += good[i] * in.nextInt();
			for(int i = 0; i < bad.length; i++)
				right += bad[i] * in.nextInt();

			System.out.print("Battle " + rr + ": ");
			if(left > right)
				System.out.println("Good triumphs over Evil");
			else if(left < right)
				System.out.println("Evil eradicates all trace of Good");
			else
				System.out.println("No victor on this battle field");
	
		}
	}
}
