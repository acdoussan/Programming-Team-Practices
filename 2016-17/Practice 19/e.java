// Adam Doussan AD844156 04/01/2017

import java.io.*;
import java.util.*;

public class e
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();

			in.nextLine();
			String test = in.nextLine();
			char [] myTest = new char [m];

			generateTests(myTest, test, k,0);
		}
	}

	public static boolean generateTests(char [] test, String goal, int k, int depth)
	{
		if(depth == test.length)
		{
			if(test(test, goal))
				return false;
			return true;
		}

		for(int i = 0; i < k; i++)
		{
			test[depth] = (char)(i + 'a');

			if(generateTests(test, goal, k, depth+1))
				return true;
		}

		return false;
	}

	public static boolean test(char [] test, String goal)
	{
		if(goal.contains(new String(test)))
			return true;
		else
		{
			System.out.println(new String(test));
			return false;
		}
	}
}
