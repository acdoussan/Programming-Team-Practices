import java.util.Scanner;

public class darts {
	public static void main(String [] args)
	{	
		Scanner in = new Scanner(System.in);
		
		int run = in.nextInt();
		
		for(int rr = 0; rr<run; rr++)
		{

			int w = in.nextInt();
			int b = in.nextInt();
			int d = in.nextInt();
			int s = in.nextInt();
			
			int t = in.nextInt();
			
			long ans = 0;
			double sect = (2*Math.PI)/w;
			
			for(int i = 0; i < t; i++)
			{
				vect v = new vect(new pt(in.nextDouble(), in.nextDouble()));
				
				if(v.mag <= b)
				{
					ans+=50;
				}
				
				else if (v.mag <= d)
				{
					ans += 2 * (((int)(v.dir/sect)) + 1);
				}
				
				else if(v.mag <= s)
				{
					ans += (((int)(v.dir/sect)) + 1);
				}
			}
			
			System.out.println(ans);
		}
	}
}

class pt
{
	double x, y;
	
	public pt(double x, double y)
	{
		this.x = x; this.y = y;
	}
}

class vect
{
	double dir;
	double mag;
	
	public vect(pt b)
	{
		mag = Math.sqrt(Math.pow(b.x-0, 2) + Math.pow(b.y-0, 2));
		
		if(b.x == 0)
		{
			if(b.y >= 0)
			{
				dir = Math.PI/2;
			}
			
			else
				dir = 3*(Math.PI/2);
		}
		
		if(b.y == 0)
		{
			if(b.x >= 0)
			{
				dir = 0;
			}
			
			else
				dir = Math.PI;
		}
			
		
		if(b.x > 0 && b.y > 0)
		{
			dir = Math.atan(b.y/b.x);
		}
		
		else if(b.x < 0 && b.y > 0)
		{
			dir = Math.atan(Math.abs(b.x/b.y)) + (Math.PI/2);
		}
		
		else if(b.x < 0 && b.y < 0)
		{
			dir = Math.atan(b.y/b.x) + Math.PI;
		}
		
		else
		{
			dir = Math.atan(Math.abs(b.x/b.y)) + (3 * (Math.PI/2));
		}
	}
}