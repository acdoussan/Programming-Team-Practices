// Adam Doussan AD844156 03/04/2017

import java.io.*;
import java.util.*;

public class igloo
{
	final public static double max = 1000;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int v = in.nextInt();
			int t = in.nextInt();

			double ans = bin(0.0, max, v, t, 79.0);

			System.out.format("%.3f\n", ans);
		}
	}

	public static double bin(double low, double high, int v, int t, double lastMid)
	{
		double mid = low + ((high - low) / 2);

		//System.out.println(mid);

		if(Math.abs(lastMid - mid) < .00001)
			return lastMid;

		double volNeeded = calcVol(mid) - calcVol(mid - t);

		//System.out.println("mid = " + mid);
		//System.out.println("volNeeded = " + volNeeded);

		if(volNeeded < v)
			return bin(mid, high, v, t, mid);

		else if(volNeeded == v)
			return mid;

		else
			return bin(low, mid, v, t, lastMid);
	}

	public static double calcVol(double r)
	{
		return ((2.0/3.0) * Math.PI * Math.pow(r, 3));
	}
}
