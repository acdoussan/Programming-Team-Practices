// Adam Doussan AD844156 03/25/2017

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class e
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int ex = in.nextInt();
		BigInteger mod = new BigInteger(in.nextInt()+"");


		BigInteger exp = new BigInteger(""+(ex - 1));

		for(int i = ex-2; i > 0; i--)
			exp = exp.multiply(new BigInteger(""+i));

		System.out.println(exp);

		BigInteger ans = fastExp(ex,exp,mod);

		System.out.println(ans);
	}

	public static BigInteger fastExp(int e, BigInteger exp, BigInteger mod)
	{
		if(exp.equals(new BigInteger(""+0)))
			return new BigInteger(""+1);

		if(exp.equals(new BigInteger(""+1)))
			return new BigInteger(""+e);

		BigInteger temp = exp.divide(new BigInteger(""+2));

		BigInteger temp1 = fastExp(e, temp, mod);

		if(exp.mod(new BigInteger(""+2)).equals(new BigInteger(""+1)))
		{
			return (temp1.multiply(temp1).multiply(new BigInteger(""+e))).mod(mod);
		}

		else
		{
			return (temp1.multiply(temp1)).mod(mod);
		}
	}
}
