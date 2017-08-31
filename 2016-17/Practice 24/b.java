//Adam Doussan AD844156 05/20/2017

import java.io.*;
import java.util.*;
import java.awt.Point;

public class b
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int numMob = in.nextInt();

		while(numMob != 0)
		{
			Point [] mob = new Point[numMob];

			for(int i = 0; i < numMob; i++)
				mob[i] = new Point(in.nextInt(), in.nextInt());

			int x = search(mob, 0);
		}
	}

	public static int search(Point [] mob, int idx)
	{
		int lo = 0, hi = Integer.MAX_VALUE;
		int last = 

		while(low < hi-1)
		{
			int mid = (hi-lo)/2 + lo;

			
		}
	}
}

