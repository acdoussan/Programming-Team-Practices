// Adam Doussan AD844156 03/04/2017

import java.io.*;
import java.util.*;

public class bonus
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int levels = in.nextInt();
			int c = in.nextInt();
			int total = 0;

			for(int j = 0; j < levels; j++)
			{
				total += in.nextInt();

				if(total >= c)
				{
					while(total >= c)
					{
						c += c;
					}

					total += c / 4;
				}
			}

			System.out.println(total);
		}
	}
}
