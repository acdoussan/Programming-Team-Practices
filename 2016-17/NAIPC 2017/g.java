// Adam Doussan AD844156 04/15/2017

import java.io.*;
import java.util.*;

class cust implements Comparable<cust>
{
	public int t, b, l, r, area, x;

	public cust(int t, int b, int l, int r, int x)
	{
		this.t = t; this.b = b; this.l = l; this.r = r; this.x = x;

		this.area = (b-t+1) * (r-l+1);
	}

	public int compareTo(cust o)
	{
		if(this.area - o.area != 0)
			return this.area - o.area;

		if(this.t - o.t != 0)
			return this.t - o.t;

		if(this.l - o.l != 0)
			return this.l - o.l;

		if((this.b-this.t+1) - (o.b-o.t+1) != 0)
			return (this.b-this.t+1) - (o.b-o.t+1);
	
		return (this.r-this.l+1) - (o.r-o.l+1);
	}

	public String toString()
	{
		return String.format("%d %d %d %d %d - %d", t,b,l,r,x,area);
	}
}

public class g
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(), m = in.nextInt(), kk = in.nextInt();

		int [][] market = new int [n][m];

		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				market[i][j] = in.nextInt();

		//for(int [] temp : market)
		//	System.out.println(Arrays.toString(temp));

		ArrayList<cust> list = new ArrayList<>();

		for(int i = 0; i < kk; i++)
		{
			list.add(new cust(in.nextInt()-1, in.nextInt()-1, in.nextInt()-1, in.nextInt()-1, in.nextInt()));
		}

		Collections.sort(list);

		//System.out.println(list);

		long ans = 0;

		for(int i = 0; i < list.size(); i++)
		{
			cust test = list.get(i);

			outer:
			for(int j = test.l; j <= test.r; j++)
			{
				for(int k = test.t; k <= test.b; k++)
				{
					if(market[k][j] <= test.x)
					{
						//System.out.println("Here");
						int take = market[k][j];
						ans += take;
						market[k][j] = 0;
						test.x -= take;
					}
					else
					{
						//System.out.println("Here2");
						int take = test.x;
						ans += take;
						market[k][j] -= take;
						test.x = 0;
						break outer;
					}
				}
			}
		}

		System.out.println(ans);

	}
}
