import java.util.*;
import java.awt.geom.*;

public class polycake {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();
		
		for(int i = 0; i < run; i++)
		{
			int v = in.nextInt();
			int y = in.nextInt();
			
			ArrayList<pt> pts = new ArrayList<pt>();
			for(int j = 0; j < v; j++)
			{
				pts.add(new pt(in.nextInt(), in.nextInt()));
			}
			
			line hor = new line(new pt(-1001,y), new pt(1001,y));
			int idx1 = -1, idx2 = -1;
			
			for(int j = 0; j < pts.size(); j++)
			{
				line temp = new line(pts.get(j), pts.get((j+1) % pts.size()));
				pt ans = temp.intersect(hor); 
				if(ans != null)
				{
					if(idx1 == -1)
					{
						idx1 = j+1;
						pts.add(j+1, ans);
						j++;
					}
					else
					{
						idx2=j+1;
						pts.add(j+1, ans);
						break;
					}
				}
			}
			
			double[] ans = new double[2];
			ans[0] = ans[1] = pts.get(idx1).dist(pts.get(idx2));
			/*
			System.out.println(ans[0]);
			System.out.println(ans[1]);
			System.out.println(pts.get(idx1));
			System.out.println(pts.get(idx2));
			*/
			
			for(int j = idx2; j != idx1; )
			{
				j=(j+1)%pts.size();
				ans[0] += pts.get(j).dist(pts.get((j+1) % pts.size()));
			}
			
			for(int j = idx1; j != idx2; )
			{
				j=(j+1)%pts.size();
				ans[1] += pts.get(j).dist(pts.get((j+1) % pts.size()));
			}
			
			Arrays.sort(ans);
			
			System.out.format("%.3f %.3f\n", ans[0], ans[1]);
			
		}
	}
}

class vect
{
	public double x,y;
	
	public vect(pt start, pt end)
	{
		x = end.x - start.x;
		y = end.y - start.y;
	}
}

class pt
{
	public double x,y;
	
	public pt(double x, double y)
	{
		this.x = x; this.y = y;
	}
	
	public double dist(pt o)
	{
		return Math.sqrt(Math.pow(o.x-x, 2) + Math.pow(o.y-y, 2));
	}
	
	public String toString()
	{
		return String.format("x=%f y=%f", x, y);
	}
}

class line
{
	pt p;
	vect dir;
	
	public line(pt start, pt end)
	{
		p=start;
		dir = new vect(start, end);
	}
	
	public pt intersect(line other)
	{
		double den = det(dir.x, -other.dir.x, dir.y, -other.dir.y);
		double numLam = det(other.p.x-p.x, -other.dir.x, other.p.y-p.y, -other.dir.y);
		
		if(Math.abs(den) < 1e-9)
		{
			return null;
		}
		else if((numLam/den)>1)
		{
			return null;
		}
		else
			return new pt(p.x + dir.x*(numLam/den), p.y + dir.y*(numLam/den));
	}
	
	public static double det( double a, double b, double c, double d)
	{
		return a*d-b*c;
	}
}
