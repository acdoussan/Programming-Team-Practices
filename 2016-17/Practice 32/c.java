//Adam Doussan AD844156 07/22/2017

import java.io.*;
import java.util.*;

class ans
{
	int a,b,c,d,e,sum;

	public ans(int a, int b , int c, int d, int e)
	{
		this.a = a; this.b = b; this.c = c; this.d = d; this.e = e;
		sum = a+b+c+d+e;
	}
}
public class c
{
	final public static int stopTop = (int)10e8;
	final public static int stopBot = (int)-10e8;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			ArrayList<ans> ans = new ArrayList<>();
			ans.add(new ans(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt()));
			int m = in.nextInt();

			while(inRange(ans.get(ans.size() - 1).sum) && ans.get(ans.size() - 1).sum < m)
			{
				ans temp = ans.get(ans.size() - 1);
				ans.add(new ans(temp.a+temp.b, temp.b+temp.c, temp.c+temp.d, temp.d+temp.e, temp.e+temp.a));

				if(ans.get(ans.size() - 1).sum == ans.get(ans.size() - 2).sum)
					break;
			}

			if(ans.get(ans.size() - 1).sum >= m)
				System.out.format("Case #%d: %d\n", rr, ans.size() - 1);
			else
				System.out.format("Case #%d: %d\n", rr, -1);
		}
	}

	public static boolean inRange(int test)
	{
		return test <= stopTop && test >= stopBot;
	}
}
