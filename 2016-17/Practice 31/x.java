//Adam Doussan AD844156 07/15/2017

import java.io.*;
import java.util.*;

class myInt implements Comparable<myInt>
{
	int val; boolean back;

	public myInt(int val, boolean back)
	{
		this.val = val; this.back = back;
	}

	public int compareTo(myInt o)
	{
		if(back)
			return o.val - this.val;
		return this.val - o.val;
	}
}

public class x
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int numVec = in.nextInt();

			myInt [] v1 = new myInt [numVec];
			myInt [] v2 = new myInt [numVec];

			for(int i = 0; i < numVec; i++)
				v1[i] = new myInt(in.nextInt(), false);
			for(int i = 0; i < numVec; i++)
				v2[i] = new myInt(in.nextInt(), true);

			Arrays.sort(v1);
			Arrays.sort(v2);

			int ans = 0;
			for(int i = 0; i < numVec; i++)
			{
				ans += v1[i].val * v2[i].val;
			}

			System.out.println(ans);
		}
	}
}
