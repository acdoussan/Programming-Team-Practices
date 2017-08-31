//Adam Doussan AD844156 10/29/2016

import java.io.*;
import java.util.*;

public class palindrometer
{

	palindrometer()
	{
		Scanner in = new Scanner(System.in);

		String start = in.nextLine();

		int numDigits = start.length();

		int miles = Integer.parseInt(start);

		while(true)
		{
			if(start.length() == 1 && miles == 0)
				break;

			solve(start, miles, numDigits);

			start = in.nextLine();
			numDigits = start.length();
			miles = Integer.parseInt(start);
		}
	}

	public void solve(String start, int miles, int numDigits)
	{
		int run = 0;

		while(!(isPalindrome(start)))
		{
			run++;
			miles++;

			int buffer = numDigits - getNumDigits(miles);

			StringBuilder newStr = new StringBuilder();

			for(int i = 0; i < buffer; i++)
				newStr.append("0");

			newStr.append(Integer.toString(miles));

			start = newStr.toString();
		}

		System.out.println(run);
	}

	public boolean isPalindrome(String arg)
	{
		int start = 0, end = arg.length() - 1;

		while(start < end)
		{
			if(arg.charAt(start) != arg.charAt(end))
				return false;

			start++;
			end--;
		}

		return true;
	}

	public int getNumDigits(int num)
	{
		if(num == 0)
			return 1;

		int cnt = 0;

		while(num != 0)
		{
			num = num / 10;
			cnt++;
		}

		return cnt;
	}

	public static void main(String [] args)
	{
		new palindrometer();
	}
}
