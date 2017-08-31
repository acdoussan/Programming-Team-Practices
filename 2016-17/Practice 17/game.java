// Adam Doussan AD844156 03/04/2017

import java.io.*;
import java.util.*;

public class game
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();
		in.nextLine();

		for(int i = 0; i < run; i++)
		{
			String test = in.nextLine();

			int current = 0, max = 0;

			for(int j = 0; j < test.length(); j++)
			{
				if(test.charAt(j) == '^')
					current--;
				if(test.charAt(j) == 'v')
				{
					current++;
					if(current > max)
						max = current;
				}
			}

			System.out.println(max);
		}
	}
}
