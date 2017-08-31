//Adam Doussan AD844156 07/01/2017

import java.io.*;
import java.util.*;

public class h
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();
		in.nextLine();

		for(int rr = 1; rr <= run; rr++)
		{
			String expr = in.nextLine();

			boolean guess = expr.charAt(expr.length() - 1) == 't';
			boolean ans = expression(expr.substring(0, expr.length() - 4), 0, expr.length() - 5);

			//System.out.println(guess);

			if(guess == ans)
				System.out.format("%d: Good brain\n", rr);
			else
				System.out.format("%d: Bad brain\n", rr);
		}
	}

	public static boolean expression(String expr, int start, int end)
	{
		//System.out.println("Start: " + start + " end: " + end);

		if(start == end)
		{
			//System.out.println("Here");
			return expr.charAt(start) == 't';
		}

		else if(expr.charAt(start) == '!')
		{
			//System.out.println("Here2");
			return !expression(expr, start+1, end);
		}

		else if(expr.charAt(start) == '(')
		{
			//System.out.println("Here3");
			int level = 1;
			char op = ' ';
			int opIdx = -1;

			for(int i = start+1; i < end; i++)
			{
				if(expr.charAt(i) == '(')
					level++;
				else if(expr.charAt(i) == ')')
					level--;
				else if(level == 1 && (expr.charAt(i) == '&' || expr.charAt(i) == '|'))
				{
					op = expr.charAt(i);
					opIdx = i;
				}
			}

			//System.out.println(opIdx);

			if(op == '&')
				return expression(expr, start+1, opIdx-1) && expression(expr, opIdx+1, end-1);
			else
				return expression(expr, start+1, opIdx-1) || expression(expr, opIdx+1, end-1);
		}

		else
		{
			//System.out.println("Here4");
			//System.out.println("Start: " + start + " end: " + end);
			boolean temp = expr.charAt(start) == 't';

			if(expr.charAt(start+1) == '&')
				return temp && expression(expr, start+2, end);
			else
				return temp || expression(expr, start+2, end);
		}
	}
/*
	public static boolean solve(String expr, int start, int end)
	{
		if(expr.charAt(start) == '(')
		{
			for(int i = start; i < end; i++)
			{
				if(expr.charAt(i) == ')')
				{
					if(i+1 == end)
					{
						return solve(expr, start+1, end-1);
					}
					else
					{
						if(expr.charAt(i+1) == '&')
							return solve(expr, start+1, i-1) && solve(expr, i+2, end);
						else
							return solve(expr, start+1, i-1) || solve(expr, i+2, end);
					}
						
				}
			}
		}

		else if(expr.charAt(start) == '!')
			return !solve(expr, start+1, end);

		else
		{
			boolean temp = (expr.charAt(start) == 't');

			for(int i = start+1; i < end; i++)
			{
				if(expr.charAt(i) == '&')
				{
					d
				}
			}
		}
	}
*/
}

