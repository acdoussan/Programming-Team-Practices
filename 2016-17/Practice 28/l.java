//Adam Doussan AD844156 06/24/2017

import java.io.*;
import java.util.*;

class Planet
{
	String name;
	int id, x, y, z;
	public Planet(String name, int id, int x, int y, int z)
	{
		this.name = name;
		this.id = id;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

class Floyd
{
	final public static int oo = (int)1e9;

	public static double [][] run(double [][] adj)
	{
		int n = adj.length;
		double [][] m = copy(adj);

		for(int k = 0; k < n; k++)
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					if(m[i][k] != oo && m[k][j] != oo)
						if(m[i][k] + m[k][j] < m[i][j])
							m[i][j] = m[i][k] + m[k][j];

		return m;
	}

	public static double [][] copy(double [][] a)
	{
		double [][] res = new double [a.length][a[0].length];
			for(int i = 0; i < a.length; i++)
				for(int j = 0; j < a[0].length; j++)
					res[i][j] = a[i][j];
		return res;
	}
}

public class l
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			HashMap<String, Planet> atop = new HashMap<>();
			HashMap<Integer, Planet> itop = new HashMap<>();

			int numP = in.nextInt();
			double [][] dist = new double [numP][numP];

			for(int i = 0; i < numP; i++)
			{
				Planet p = new Planet(in.next(), atop.size(), in.nextInt(), in.nextInt(), in.nextInt());
				atop.put(p.name, p);
				itop.put(p.id, p);
			}

			for(int i = 0; i < numP; i++)
				for(int j = 0; j < numP; j++)
					dist[i][j] = distance(itop.get(i), itop.get(j));

			int wh = in.nextInt();

			for(int i = 0; i < wh; i++)
				dist[atop.get(in.next()).id][atop.get(in.next()).id] = 0;

			dist = Floyd.run(dist);

			int query = in.nextInt();

			System.out.println("Case " + rr + ":");

			for(int i = 0; i < query; i++)
			{
				Planet p1 = atop.get(in.next());
				Planet p2 = atop.get(in.next());
				System.out.format("The distance from %s to %s is %d parsecs.\n",
									p1.name, p2.name, Math.round(dist[p1.id][p2.id]));
			}
		}
	}

	public static double distance(Planet a, Planet b)
	{
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2) + Math.pow(a.z - b.z, 2));
	}
}
