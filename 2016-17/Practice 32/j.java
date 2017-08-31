//Adam Doussan AD844156 07/22/2017

import java.io.*;
import java.util.*;

public class j
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int strct = in.nextInt();

			String [] str = new String[strct];

			for(int i = 0; i < strct; i++)
				str[i] = in.next();

			long ans = 0;

			for(int i = 0; i < strct; i++)
			{
				for(int j = 0; j < strct; j++)
				{
					if(i != j)
					{
						if(isPalindrome(str[i] + str[j]))
						{
							ans++;
						}
					}
				}
			}

			System.out.format("Case #%d: %d\n", rr, ans);
		}
	}

	public static boolean isPalindrome(String test)
	{
		boolean ans = true;
		for(int i = 0; i < test.length() / 2; i++)
		{
			if(test.charAt(i) != test.charAt(test.length() - i - 1))
			{
				ans = false;
				break;
			}
		}
		return ans;
	}
}
