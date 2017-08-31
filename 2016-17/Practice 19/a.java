// Adam Doussan AD844156 04/01/2017

import java.io.*;
import java.util.*;

public class a
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int test = in.nextInt();

			if(absurd(test))
				System.out.println("absurd");
			else
				System.out.println("not absurd");
		}
	}

	public static boolean absurd(int test)
	{
		int myAbs = getAbs(test);

		int low = (int)(test * .95);
		int high = (int)(test * 1.05);

		if(numDig(low) < numDig(high))
		{
			if(2 < myAbs)
				return true;
			return false;
		}

		int lowestAbs = getAbs(low);

		for(int i = low; i <= high; i++)
		{
			int temp = i;

			while(temp % 10 == 0)
				temp /= 10;

			lowestAbs = Math.min(lowestAbs, getAbs(temp));

			if(temp % 10 == 5)
				break;
		}

/*
		if(high % 10 < 5)
		{
			int temp = high / 10;
			boolean lowCalc = false;

			for(int i = 0; i < numDig(temp) - 1; i++)
			{
				if(temp % 10 > 0)
				{
					lowCalc = true;
					break;
				}
				temp /= 10;
			}

			int temp;

			if(lowCalc)
			{
				temp = (numDig(high) * 2) - 1;
			}
			else
			{
				temp = (numDig(high) * 2);
			}

			lowestAbs = Math.min(lowestAbs, temp);
		}
*/

		//System.out.println(myAbs + " " + lowestAbs);

		return lowestAbs < myAbs;
	}

	public static int getAbs(int test)
	{
		while(test % 10 == 0)
			test /= 10;

		return (test % 10 == 5) ? (numDig(test) * 2) - 1 : numDig(test) * 2;
	}

	public static int numDig(int a)
	{
		if(a == 0)
			return 1;

		int temp = 0;

		while(a != 0)
		{
			temp++;
			a /= 10;
		}

		return temp;
	}
}
