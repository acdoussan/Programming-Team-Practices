//Adam Doussan AD844156 07/18/2017

import java.io.*;
import java.util.*;

public class j
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		long [] ans = new long [(int)10e6+1]; 

		ans[1] = 1;
		ans[2] = 1;

		for(int i = 3; i <= 10e6; i++)
		{
			long t1 = (ans[i-1] * (i-1)) % 1000000007;
			long t2 = (ans[i-2] * (i-2)) % 1000000007;
			ans[i] = (t1+t2) % 1000000007;
		}

		for(int rr = 1; rr <= run; rr++)
		{
			System.out.format("Case %d: %d\n", rr, ans[in.nextInt()]);
		}
	}
}
