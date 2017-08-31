//Adam Doussan AD844156 06/03/2017

import java.io.*;
import java.util.*;

public class between
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int numa = in.nextInt();
			int [] a = new int [numa];

			for(int i = 0; i < numa; i++)
				a[i] = in.nextInt();

			int numb = in.nextInt();
			int [] b = new int [numb];

			for(int i = 0; i < numb; i++)
				b[i] = in.nextInt();

			System.out.println(numa);
			System.out.println(Arrays.toString(a));
			System.out.println(numb);
			System.out.println(Arrays.toString(b));

			int best = Integer.MAX_VALUE;//Math.abs(a[0] - b[0]);

			for(int i = 0; i < numa; i++)
				for(int j = 0; j < numb; j++)
					if(Math.abs(a[i] - b [j]) < best)
						best = Math.abs(a[i] - b [j]);

			System.out.println(best);
		}
	}
}
