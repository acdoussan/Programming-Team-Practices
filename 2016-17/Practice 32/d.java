//Adam Doussan AD844156 07/22/2017

import java.io.*;
import java.util.*;
import java.awt.geom.*;
//import java.awt.geom.Line2D.Double;
//import java.awt.geom.Point2D.Double;

class Polygon
{
	public static boolean ptInPoly(pt intersect, pt [] poly)
	{
		double totalAngle = 0;

		for(int i = 0; i < poly.length; i++)
		{
			pt v1 = intersect.vect(poly[i]);
			pt v2 = intersect.vect(poly[(i+1)%poly.length]);

			try
			{
				totalAngle += Math.acos((v1.dot(v2)) / (v1.mag() * v2.mag()));
			}
			catch(Exception e)
			{
			}
		}

		boolean ans1 = (2*Math.PI) - totalAngle < 1e-9;
		boolean ans2 = false;

		if(ans1 == false)
		{
			Point2D.Double inter = new Point2D.Double(intersect.x, intersect.y);
			for(int i = 0; i < poly.length; i++)
			{
				Line2D.Double line = new Line2D.Double(new Point2D.Double(poly[i].x, poly[i].y),new Point2D.Double(poly[(i+1)%poly.length].x, poly[(i+1)%poly.length].y));

				if(line.contains(inter))
				{
					ans2 = true;
					break;
				}
				else
				{
					System.out.println("what");
				}
			}
		}

		return ans1 || ans2;
	}
}

class pt
{
	public double x, y, z;
	int id;

	pt(double x, double y, double z, int id)
	{
		this.x = x; this.y = y; this.z = z; this.id = id;
	}

	public pt vect(pt pt2)
	{
		return new pt(pt2.x-x, pt2.y-y, pt2.z-z, 0);
	}

	public pt cross(pt pt2)
	{
		double x = this.y * pt2.z - pt2.y * this.z;
		double y = this.z * pt2.x - pt2.z * this.x;
		double z = this.x * pt2.y - pt2.x * this.y;

		return new pt(x,y,z,0);
	}

	public double mag()
	{
		return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2));
	}

	public double dot(pt vect)
	{
		return (this.x * vect.x) + (this.y * vect.y) + (this.z * vect.z);
	}

	public double dist(pt o)
	{
		return Math.sqrt(Math.pow(this.x - o.x,2) + Math.pow(this.y - o.y,2) + Math.pow(this.z - o.z,2));
	}
}

public class d
{
	public static void main(String [] args)
	{
//*
		pt [] poly = new pt[3];
		poly [0] = new pt(4,0,0,0);
		poly [1] = new pt(4,2,0,0);
		poly [2] = new pt(0,2,0,0);

		pt inter = new pt(2,1,0,0);

		System.out.println(Polygon.ptInPoly(inter, poly));
//*/
/*
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			System.out.format("Case #%d:\n", rr);

			int n = in.nextInt();
			pt[] towers = new pt[n];

			for(int i = 0; i < n; i++)
				towers[i] = new pt(in.nextInt(), in.nextInt(), 0, i+1);

			int r = in.nextInt();

			for(int i = 0; i < r; i++)
			{
				System.out.format("Region %d\n", i+1);
				int b = in.nextInt();

				pt[] poly = new pt[b];

				for(int j = 0; j < b; j++)
					poly[j] = new pt(in.nextInt(), in.nextInt(), 0, 0);

				reverse(poly);

				ArrayList<pt> inReg = new ArrayList<>();

				for(pt t : towers)
					if(Polygon.ptInPoly(t, poly))
						inReg.add(t);

				int m = in.nextInt();

				for(int j = 0; j < m; j++)
				{
					pt newTower = new pt(in.nextInt(), in.nextInt(), 0, 0);

					if(inReg.size() < 2)
					{
						System.out.println("Wrong");
						continue;
					}

					double t1 = newTower.dist(inReg.get(0)), t2 = newTower.dist(inReg.get(1));
					pt p1 = inReg.get(0), p2 = inReg.get(1);

					if(t1 < t2 || (t1 == t2 && p1.id > p2.id))
					{
						double temp = t1;
						t1 = t2;
						t2 = temp;

						pt ptemp = p1;
						p1 = p2;
						p2 = ptemp;
					}

					for(pt tower : inReg)
					{
						double dist = newTower.dist(tower);

						if(dist < t1 || (dist == t1 && p1.id > tower.id))
						{
							t2 = t1;
							p2 = p1;
							t1 = dist;
							p1 = tower;
						}

						else if(dist < t2 || (dist == t2 && p2.id > tower.id))
						{
							t2 = dist;
							p2 = tower;
						}
					}

					System.out.format("%d %d\n", p1.id, p2.id);
				}
			}
		}
//*/
	}

	public static void reverse(pt [] poly)
	{
		for(int i = 0; i < poly.length/2; i++)
		{
			pt temp = poly[i];
			poly[i] = poly[poly.length - i - 1];
			poly[poly.length - i - 1] = temp;
		}
	}
}
