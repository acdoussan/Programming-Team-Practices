//Adam Doussan AD844156 01/14/2017

import java.io.*;
import java.util.*;

public class h
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();
		in.nextLine();

		for(int i = 0; i < run; i++)
		{
			String test = in.nextLine();

			int nextSquare = getNext(test.length());
			int square = (int) Math.sqrt(nextSquare);

			char [][] start = new char[square][square];

			for(int j = 0; j < square; j++)
			{
				for(int k = 0; k < square; k++)
				{
					start[j][k] = ((j * square) + k < test.length()) ? (test.charAt((j * square) + k)) : '*';
				}
			}

			StringBuilder ans = new StringBuilder();

			for(int j = 0; j < square; j++)
			{
				for(int k = square - 1; k >= 0; k--)
				{
					if(Character.isAlphabetic(start[k][j]))
						ans.append(start[k][j]);
				}
			}

			System.out.println(ans.toString());

		}
	}

	public static int getNext(int a)
	{
		double test1 = Math.sqrt(a);
		int test2 = (int) test1;

		while(test1 != (double)test2)
		{
			a++;
			test1 = Math.sqrt(a);
			test2 = (int) test1;
		}

		return a;
	}
}
