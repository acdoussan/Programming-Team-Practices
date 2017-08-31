// Adam Doussan AD844156 04/22/2017

import java.io.*;
import java.util.*;

public class riverwalk
{
	public static long ans;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int v = in.nextInt(), d = in.nextInt();

			int [] price = new int[v];
			for(int j = 0; j < v; j++)
				price[j] = in.nextInt();

			ans = 0;
			Arrays.sort(price);
			combs(price, 0, new boolean[v], 0, d);

			System.out.println(ans);
		}
	}

	public static void combs(int[] price, int total, boolean[] take, int depth, int max)
	{
		if(depth == take.length)
		{
			//System.out.println("Here");
			for(int i = 0; i < take.length; i++)
				if(!take[i] && (max - total >= price[i]))
					return;

			ans++;
			return;
		}

		if(total+price[depth] <= max)
		{		
			take[depth] = true;
			combs(price, total + price[depth], take, depth+1, max);
		}

		take[depth] = false;
		combs(price, total, take, depth+1, max);
	}
}
