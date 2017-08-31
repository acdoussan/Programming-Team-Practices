// Adam Doussan AD844156 04/07/2017

import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class tidy
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 1; i <= run; i++)
		{
			String test = in.next();

			char [] temp = test.toCharArray();

			char [] ans = tidy(temp);

			System.out.format("Case #%d: %d\n", i, Long.parseLong(new String(ans)));
		}
	}

	public static char [] tidy(char [] test)
	{
		if(test.length <= 1)
			return test;

		for(int i = test.length - 1; i > 0; i--)
		{
			if(test[i] - '0' < test[i - 1] - '0')
			{
				fill9(test, i);
				test[i-1] = (char)((test[i - 1] == '0') ? '0' : test[i - 1] - '0' - 1 + '0');
			}
		}

		return test;
	}

	public static void fill9(char [] test, int to)
	{
		for(int i = test.length-1; i >= to; i--)
			test[i] = '9';
	}
}
