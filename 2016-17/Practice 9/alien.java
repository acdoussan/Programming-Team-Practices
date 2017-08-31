//Adam Doussan AD844156 12/03/2016

import java.io.*;
import java.util.*;

public class alien
{
	final public static int [] atoi = {10,11,12,13,14,15,16,17,18,19,20,21,22,23,
												  24,25,26,27,28,29,30,31,32,33,34,35};
	final public static char [] itoa = {'0','1','2','3','4','5','6','7','8','9',
													'A','B','C','D','E','F','G','H','I','J',
													'K','L','M','N','O','P','Q','R','S','T',
													'U','V','W','X','Y','Z'};

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();
		in.nextLine();
		for(int i = 0; i < run; i++)
		{
			int x = Integer.parseInt(in.next());
			int y = Integer.parseInt(in.next());
			solve(x,y,in.next());
		}
	}

	public static void solve(int base1, int base2, String num)
	{
		long input = toDec(base1, num);
		String ans = toAns(base2, input);
		System.out.println(ans);
	}

	public static long toDec(int base,String num)
	{
		long ans = 0;

		for(int i = 0; i < num.length(); i++)
		{
			ans *= base;

			if(Character.isAlphabetic(num.charAt(i)))
			{
				ans += atoi[num.charAt(i) - 'A'];
			}
			else
			{
				ans += num.charAt(i) - '0';
			}
		}

		return ans;
	}

	public static String toAns(int base, long num)
	{
		if(num == 0)
			return "0";

		StringBuilder ans = new StringBuilder();

		while(num > 0)
		{
			ans.insert(0, itoa[(int)(num % base)]);
			num /= base;
		}

		return ans.toString();
	}
}
