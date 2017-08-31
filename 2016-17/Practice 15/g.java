// Adam Doussan AD844156 02/11/2017

import java.io.*;
import java.util.*;
import java.awt.Point;

public class g
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		Point v1 = new Point(in.nextInt(), in.nextInt());
		Point v2 = new Point(in.nextInt(), in.nextInt());
		Point v3 = new Point(in.nextInt(), in.nextInt());

		double a = dist(v1,v2);
		double b = dist(v2,v3);
		double c = dist(v3,v1);

		double r = in.nextDouble();

		double A = Math.sqrt((4*Math.pow(a, 2)*Math.pow(b, 2)) - Math.pow(((Math.pow(a, 2)) + (Math.pow(b, 2)) - (Math.pow(c, 2))), 2)) / 4;

		double thisAns = A * (((double)2)/ (a + b + c));

		double perc = ((thisAns - r) / r) * 100;

		System.out.format("%.3f\n", perc);
	}

	public static double dist(Point v1, Point v2)
	{
		return Math.sqrt(Math.pow(v1.x - v2.x, 2) + Math.pow(v1.y - v2.y, 2));
	}
}
