//Adam Doussan AD844156 07/08/2017

import java.io.*;
import java.util.*;

public class shade
{


	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int trees = in.nextInt();

		while(true)
		{
			if(trees == 0)
				break;

			circ [] myTrees = new circ[trees];

			for(int i = 0; i < trees; i++)
				myTrees[i] = new circ(in.nextInt(), in.nextInt(), in.nextInt());

			double ans = 0;
			sun.reset();

			for(int i = 0; i < 1440; i++)
			{
				ans = Math.max(ans, sun.getShade(myTrees));
				sun.advance();
			}

			System.out.format("%.3f\n", ans);

			trees = in.nextInt();
		}
	}
}

class sun
{
	public static int r = 500;
	public static int offset = 0;
	public static pt ori = new pt(0,0);

	public static void reset()
	{
		offset = 0;
	}

	public static pt get()
	{
		return new pt(
			r * Math.cos((2*Math.PI) * (offset/((double)1440))),
			r * Math.sin((2*Math.PI) * (offset/((double)1440)))
			);
	}

	public static void advance()
	{
		offset++;
	}

	public static double getShade(circ[] trees)
	{
		double ans = 0;

		for(int i = 0; i < trees.length; i++)
		{
			//System.out.println(LineCircleIntersect.intersect(ori, sun.get(), trees[i]));
			ans += LineCircleIntersect.intersect(ori, sun.get(), trees[i]);
		}

		return ans;
	}
}

class LineCircleIntersect
{
    public static double intersect(pt start, pt end, circ circle)
    {
		double dx = end.x - start.x;
		double dy = end.y - start.y;

		double a = ((dx*dx)+(dy*dy));
		double b = 2 * (dx * (start.x - circle.x) + dy * (start.y - circle.y));
		double c = ((start.x - circle.x) * (start.x - circle.x))
					+ ((start.y - circle.y) * (start.y - circle.y))
					- (circle.radius * circle.radius);

		double det = (b*b) - (4 * a * c);

		if (det < 0)
			return 0;

		double soln1 = ((-1 * b) + Math.sqrt(det))/(2*a);
		double soln2 = ((-1 * b) - Math.sqrt(det))/(2*a);

		if (((soln1 < 0) || (soln1 > 1)) && ((soln2 < 0) || (soln2 > 1)))
			return 0;

		return dist(new pt(dx*soln1, dy*soln1), new pt(dx*soln2, dy*soln2));
    }

	public static double dist(pt a, pt b)
	{
		return Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2));
	}
}

class pt
{
	double x,y;

	public pt(int x, int y)
	{
		this.x = x; this.y = y;
	}
	public pt(double x, double y)
	{
		this.x = x; this.y = y;
	}
}

class circ
{
	double x,y;
	double radius;

	public circ(int x, int y, int r)
	{
		this.x = x; this.y = y; this.radius = r;
	}
}
