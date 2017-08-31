//Adam Doussan AD844156 01/14/2017

import java.io.*;
import java.util.*;

public class f
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();
		in.nextLine();

		for(int i = 0; i < run; i++)
		{
			String test = in.nextLine();

			boolean [] ans = new boolean[26];

			for(int j = 0; j < test.length(); j++)
			{
				if(Character.isAlphabetic(test.charAt(j)))
				{
					if(Character.isUpperCase(test.charAt(j)))
					{
						ans[test.charAt(j) - 'A'] = true;
					}

					else
					{
						ans[test.charAt(j) - 'a'] = true;
					}
				}
			}

			boolean pass = true;

			for(int j = 0; j < 26; j++)
			{
				if(ans[j] == false)
				{
					pass = false;
					break;
				}
			}

			if(pass)
				System.out.println("pangram");
			else
				printMissing(ans);
		}
	}

	public static void printMissing(boolean [] ans)
	{
		System.out.print("missing ");

		for(int i = 0; i < 26; i++)
		{
			if(!ans[i])
				System.out.print((char)((int)'a' + i));
		}

		System.out.println();
	}
}
