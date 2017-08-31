// Adam Doussan AD844156 03/25/2017

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class d
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		BigInteger ans = new BigInteger("100");
		BigInteger max = new BigInteger("100000");
		int last = in.nextInt();

		for(int i = 1; i < run; i++)
		{
			int temp = in.nextInt();
			if(temp > last)
			{
				BigInteger canBuy = ans.divide(new BigInteger(""+last));
				if(canBuy.compareTo(max) > 0)
					canBuy = max;
				ans = ans.add(canBuy.multiply(new BigInteger((temp - last) + "")));
			}

			last = temp;
		}

		System.out.println(ans);
	}
}
