//Adam Doussan AD844156 10/29/2016

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class bitcounting
{
	HashMap<BigInteger, Integer> memo;

	bitcounting()
	{
		Scanner in = new Scanner(System.in);

		memo = new HashMap<>();

		BigInteger Lo = new BigInteger(in.next()), Hi = new BigInteger(in.next());
		int X = Integer.parseInt(in.next());

		while(true)
		{
			if(Lo.equals(0) && Hi.equals(0) && X == 0)
				break;

			BigInteger ans = solve(Lo, Hi, X);

			System.out.println(ans.toString());

			Lo = new BigInteger(in.next()); Hi = new BigInteger(in.next());
			X = Integer.parseInt(in.next());
		}
	}

	public BigInteger solve(BigInteger lo, BigInteger hi, int x)
	{
		BigInteger cnt = new BigInteger("0");

		for(BigInteger i = lo; !(i.equals(hi.add(BigInteger.ONE))); i = i.add(BigInteger.ONE))
		{
			if((help(i) - 1) == x)
				cnt = cnt.add(BigInteger.ONE);
		}

		return cnt;
	}

	public int help(BigInteger num)
	{
		if(memo.containsKey(num))
			return memo.get(num);

		if(num.equals(BigInteger.ONE))
			return 1;

		int ans = (1 + help(find(num)));

		//System.out.println(num + " = " + ans);

		memo.put(num, ans);

		return ans;
	}

	public BigInteger find(BigInteger num)
	{
		if(num.equals(BigInteger.ZERO))
			return BigInteger.ZERO;

		if(num.equals(BigInteger.ONE))
			return BigInteger.ONE;

		BigInteger two = new BigInteger("2");

		if(num.mod(two).equals(BigInteger.ONE))
			return (BigInteger.ONE.add(find(num.divide(two))));

		return find(num.divide(two));
	}

	public static void main(String [] args)
	{
		new bitcounting();
	}
}
