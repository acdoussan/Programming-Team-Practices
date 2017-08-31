// Adam Doussan AD844156 02/11/2017

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class i
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		BigInteger temp1 = new BigInteger("4");
		BigInteger temp2 = new BigInteger("2");

		temp1 = temp1.pow(n);
		temp2 = temp2.pow(n);

		BigInteger ans = temp1.multiply(temp2);

		System.out.println(ans);
	}
}
