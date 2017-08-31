//Adam Doussan AD844156 05/13/2017

import java.io.*;
import java.util.*;

class circ
{
	int i, r;

	public circ(int i, int r)
	{
		this.i = i; this.r = r;
	}
}

public class c
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		HashMap<Integer, ArrayList<circ> circs = new HashMap<>();
		HashMap<Integer, ArrayList<circ>> edges = new HashMap<>():
 
		int ans = 1;

		for(int rr = 1; rr <= run; rr++)
		{
			circ c = new circ(in.nextInt(), in.nextInt());
			ans++;

			if(circs.containsKey(c.i))
				circs.get(c.i).add(c);
			else
				circs.add(c.i, new ArrayList<>().add(c));


			if(edges.containsKey(c.i+c.r) && c.i-c.r >= (int) -1e9)
				if(edges.containsKey(c.i+c.r) && edges.containsKey(c.i-c.r))
					for(circ temp : edges.get(c.i+c.r))
						if(edges.)

			if(c.i+c.r <= (int) 1e9)
			{
				if(edges.containsKey(c.i+c.r))
				{
				
					edges.get(c.i+c.r).add(c);
				}
				else
					edges.add(c.i+c.r, new ArrayList<>().add(c));
			}

			if(c.i-c.r >= (int) -1e9)
			{
				if(edges.containsKey(c.i-c.r))
					edges.get(c.i-c.r).add(c);
				else
					edges.add(c.i-c.r, new ArrayList<>().add(c));
			}

			try
			{
				if(circs[i+2*circs[i]] == circs[i])
					if(circs[i+circs[i]] == 2*circs[i])
						ans += 2;
				if(circs[i-2*circs[i]] == circs[i])
					if(circs[i-circs[i]] == 2*circs[i])
						ans += 2;
			}
			catch(Exception e)
			{
			}	
		}

		System.out.println(ans);
	}
}
