// Adam Doussan AD844156 03/25/2017

import java.io.*;
import java.util.*;

public class g
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		String test = in.nextLine();

		int runningWin = 0;
		int stars = 0;
		int level = 25;
		int [] needed = {(int) 1e9,5,5,5,5,5,5,5,5,5,5,4,4,4,4,4,3,3,3,3,3,2,2,2,2,2};

		for(int i = 0; i < test.length(); i++)
		{
			if(test.charAt(i) == 'W')
			{
				if(level == 0)
					continue;

				runningWin++;

				if(runningWin >= 3 && level >= 6)
					stars += 2;
				else
					stars++;

				//System.out.println(stars);

				if(stars > needed[level])
				{
					stars -= needed[level--];
				}
			}

			else if(test.charAt(i) == 'L')
			{
				if(level == 0)
					continue;

				runningWin = 0;

				if(stars == 0 && level < 20)
				{
					stars = needed[++level] - 1;
				}

				else if(level < 21 && stars != 0)
					stars--;
			}
		}

		if(level == 0)
			System.out.println("Legend");
		else
			System.out.println(level);
	}
}
