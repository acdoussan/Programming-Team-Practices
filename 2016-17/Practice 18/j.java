// Adam Doussan AD844156 03/25/2017

import java.io.*;
import java.util.*;

public class j
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int comp = in.nextInt();
		int change = in.nextInt();
		int test = comp - change;

		if(test == 180 || test == -180)
			System.out.println(180);

		else if(test == 0)
			System.out.println(0);

		else if(test < 0)
		{
			test = -test;

			if(test < 180)
				System.out.println(test);
			else
			{
				test = 360 - test;
				System.out.println(-test);
			}
		}

		else if(test > 0)
		{
			if(test < 180)
				System.out.println(-test);
			else
			{
				test = 360 - test;
				System.out.println(test);
			}
		}
	}
}
