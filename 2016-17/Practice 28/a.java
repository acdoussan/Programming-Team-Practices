//Adam Doussan AD844156 06/24/2017

import java.io.*;
import java.util.*;

class value
{
	char [] digits;
	boolean hasLeadingQ = false;
	public value(String v)
	{
		digits = v.toCharArray();

		for(int i = 0; i < digits.length; i++)
		{
			if(digits[0] == '?' && digits.length > 1 || (digits[0] == '-' && digits[1] == '?' && digits.length > 2))
				hasLeadingQ = true;
		}
	}

	public int getVal(int repl)
	{
		int retVal = 0;

		for(int i = 0; i < digits.length; i++)
		{
			retVal *= 10;

			if(digits[i] == '?')
			{
				retVal += repl;
			}

			else if(!Character.isDigit(digits[i]))
			{
				continue;
			}

			else
			{
				retVal += (int)(digits[i] - '0');
			}
		}

		if(digits[0] == '-')
			return 0 - retVal;
		else
			return retVal;
	}

	public void mark(boolean[] canUse)
	{
		for(int i = 0; i < digits.length; i++)
			if(Character.isDigit(digits[i]))
				canUse[digits[i] - '0'] = false;
	}
}

public class a
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();
		in.nextLine();

		for(int rr = 1; rr <= run; rr++)
		{
			String test = in.nextLine();
			String a, b, c;
			char op = ' ';
			int opIdx = 0;
			int eqIdx = 0;
			

			for(int i = 1; i < test.length(); i++)
			{
				if(!Character.isDigit(test.charAt(i)) && test.charAt(i) != '?')
				{
					op = test.charAt(i);
					opIdx = i;
					break;
				}
			}
			for(int i = 1; i < test.length(); i++)
			{
				if(test.charAt(i) == '=')
				{
					eqIdx = i;
					break;
				}

			}
			a = test.substring(0,opIdx);
			b = test.substring(opIdx+1, eqIdx);
			c = test.substring(eqIdx+1);
/*
			System.out.println(a);
			System.out.println(op);
			System.out.println(b);
			System.out.println(c);
			System.out.println();
*/
			System.out.println(solve(new value(a),new value(b),new value(c),op));
//			System.out.println();
		}
	}

	public static int solve(value a, value b, value c, char op)
	{
		int i;
		if(a.hasLeadingQ || c.hasLeadingQ || c.hasLeadingQ)
			i = 1;
		else
			i = 0;

		boolean [] canUse = new boolean[10];
		Arrays.fill(canUse, true);

		a.mark(canUse);
		b.mark(canUse);
		c.mark(canUse);

		for(; i < 10; i++)
		{
			if(canUse[i])
			{
				if(op == '*')
					if((a.getVal(i) * b.getVal(i)) == c.getVal(i))
						return i;

				if(op == '+')
					if((a.getVal(i) + b.getVal(i)) == c.getVal(i))
						return i;

				if(op == '-')
					if((a.getVal(i) - b.getVal(i)) == c.getVal(i))
						return i;
			}
		}

		return -1;
	}
}
